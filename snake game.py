
import tkinter as tk , random

#==========================================
# Purpose: SnakeGui essentially creates the game board and runs the game
# Instance variables:
##self.win = opens the tk widget
##self.canvas = creates canvas board the game is played on
##self.board = self.canvas.create_rectangle(30, 30, 630, 630)
##self.snake = creates the player controled snake of the Snake class
##self.snake_c = creates the enemy snake of the c_snake
##self.randx = random x coord of the food pellet
##self.randy = random y coord of the food pellet 
##self.apple = draws the food pellet on the canvas
# Methods: (What methods does this class have, and what does each do?)
# __init__ = initalizes all the instance variables
# gameloop = runs the game only if player hasn't lost otherwise the game ends if player loses
# restart = restarts the game only if the player lost
#==========================================

class SnakeGUI:
    def __init__(self):
        self.win = tk.Tk()
        self.canvas = tk.Canvas(self.win, width = 660, height = 660)
        self.canvas.pack()
        self.board = self.canvas.create_rectangle(30, 30, 630, 630)
        self.snake = Snake(330,330, color='green', canvas=self.canvas)
        self.snake_c = c_Snake(210,330, color='red', canvas=self.canvas)
        self.randx = random.randint(1, 20) * 30
        self.randy = random.randint(1, 20) * 30 
        self.apple = self.canvas.create_oval(self.randx, self.randy, self.randx + 30, self.randy + 30, fill='red')
        self.win.bind('<Down>',self.snake.go_down)
        self.win.bind('<Up>',self.snake.go_up)
        self.win.bind('<Left>',self.snake.go_left)
        self.win.bind('<Right>',self.snake.go_right)
        self.win.bind('<r>',self.restart)
        self.game = True
        self.gameloop()
    def gameloop(self):
        if self.game == True:
            if self.snake.move(self.randx, self.randy) == False or self.snake_c.move(self.randx, self.randy)== False:
                self.canvas.delete(self.apple)
                self.randx = random.randint(1, 20) * 30
                self.randy = random.randint(1, 20) * 30
                self.apple = self.canvas.create_oval(self.randx, self.randy, self.randx + 30, self.randy + 30, fill='red')
            if self.snake.x > 600 or self.snake.x < 30 or self.snake.y < 30 or self.snake.y > 600 or self.snake.hit() == True:
                self.game = False
                self.canvas.create_text(330, 330, text='you lost! Score = '+str(len(self.snake.segments)))
                
   
            self.canvas.after(100, self.gameloop)
    def restart(self, event):
        if self.game == False:
            self.canvas.delete(tk.ALL)
            self.board = self.canvas.create_rectangle(30, 30, 630, 630)
            self.snake = Snake(330,330, color='green', canvas=self.canvas)
            self.snake_c = c_Snake(210,330, color='red', canvas=self.canvas)
            self.randx = random.randint(1, 20) * 30
            self.randy = random.randint(1, 20) * 30 
            self.apple = self.canvas.create_oval(self.randx, self.randy, self.randx + 30, self.randy + 30, fill='red')
            self.win.bind('<Down>',self.snake.go_down)
            self.win.bind('<Up>',self.snake.go_up)
            self.win.bind('<Left>',self.snake.go_left)
            self.win.bind('<Right>',self.snake.go_right)
            self.win.bind('<r>',self.restart)
            self.game = True
            self.gameloop()
#==========================================
# Purpose: makes the player controlled snake
# Instance variables:
##self.x = starting x coord of player controlled snake
##self.y = starting y coord of player controlled snake
##self.color = color player controlled snake
##self.canvas = canvas of where snake is made on
##self.id = draws the rectangle of snake
##self.segments = list of all segments of the player snake
##self.vx = x direction of player snake ex. left or right
##self.vy = y direction of player snake ex. up or down
# Methods: (What methods does this class have, and what does each do?)
# __init__ = initalizes all the instance variables
# move = moves the player controlled snake on the canvas board
# hit = can tell wheather the snake runs into itself
# go_up = changes the vy direction so the snake moves up
# go_down = changes the vy direction so the snake moves down
#go left = changes the vx direction so the snake moves left
# go_right = changes the vx direction so the snake moves right
#==========================================

class Snake:
    def __init__(self, x, y, color, canvas):
        self.x = x
        self.y = y
        self.color = color
        self.canvas = canvas
        self.id = self.canvas.create_rectangle(self.x, self.y, self.x+30, self.y+30 ,fill = self.color)
        self.segments = [self.id]
        self.vx = 30
        self.vy = 0
    def move(self, randx, randy):
        self.x += self.vx
        self.y += self.vy
        self.randx = randx
        self.randy = randy
        self.id = self.canvas.create_rectangle(self.x, self.y, self.x+30, self.y+30 ,fill = self.color)
        self.segments.insert(0,self.id)
        self.snake_coords = self.canvas.coords(self.id)
                
        if self.snake_coords[0] == self.randx and self.randy == self.snake_coords[1]:
            return False
        else:
            self.remove = self.segments.pop()
            self.canvas.delete(self.remove)
    def hit(self):
         for i in range(1, len(self.segments)):
            if self.snake_coords[0] == self.canvas.coords(self.segments[i])[0] and self.canvas.coords(self.segments[i])[1] == self.snake_coords[1]:
                return True
    def go_down(self, event):
        self.vx = 0
        self.vy = 30
    def go_up(self, event):
        self.vx = 0
        self.vy = -30
    def go_left(self, event):
        self.vx = -30
        self.vy = 0
    def go_right(self, event):
        self.vx = 30
        self.vy = 0
#==========================================
# Purpose: creates a computer controlled enemy snake 
# Instance variables:
##self.x = starting x coord of player controlled snake
##self.y = starting y coord of player controlled snake
##self.color = color player controlled snake
##self.canvas = canvas of where snake is made on
##self.id = draws the rectangle of snake
##self.segments = list of all segments of the player snake
##self.vx = x direction of player snake ex. left or right
##self.vy = y direction of player snake ex. up or down
# Methods:
# initalizes all the instance variables
# move = moves the player controlled snake on the canvas board according to where the food pellet is located
#==========================================

class c_Snake:
    def __init__(self, x, y, color, canvas):
        self.x = x
        self.y = y
        self.color = color
        self.canvas = canvas
        self.id = self.canvas.create_rectangle(self.x, self.y, self.x+30, self.y+30 ,fill = self.color)
        self.segments = [self.id]
        self.vx = 0
        self.vy = 0
    def move(self, randx, randy):
        self.randx = randx
        self.randy = randy
        self.id = self.canvas.create_rectangle(self.x, self.y, self.x+30, self.y+30 ,fill = self.color)
        self.segments.insert(0,self.id)
        self.snake_coords = self.canvas.coords(self.id) 
        if self.y > self.randy:
            self.vx = 0
            self.vy = -30
        elif self.y == self.randy:
            if self.x < self.randx:
                self.vx = 30
                self.vy = 0
            elif self.x > self.randx:
                self.vx = -30
                self.vy = 0
        elif self.y < self.randy:
            self.vx = 0
            self.vy = 30
        self.x += self.vx
        self.y += self.vy
        if self.x == self.randx and self.randy == self.y:
            return False
        else:
            self.remove = self.segments.pop()
            self.canvas.delete(self.remove)
    
SnakeGUI()
tk.mainloop()
