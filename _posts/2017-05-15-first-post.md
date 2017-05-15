---
layout: post
title: Summer Plans
---

Well, I've moved into my new place and given myself a week or so to look for jobs and take a breather from school. Man, does it feel good. Let's just see how jekyll works:

With any luck, this should be highlighted properly:

{% highlight python %}
#python2
import pygame
pygame.init()

size = (800,600)
screen = pygame.display.set_mode(size)
pygame.display.set_caption("RCF-PyGame test")
done = False
clock = pygame.time.Clock()
font = pygame.font.SysFont('FreeSans',25,True,False)

# Define
BLACK = (0,0,0)
WHITE = (255,255,255)
GREEN = (0,255,0)
RED = (255,0,0)
BLUE = (0,0,255)
PI = 3.1415296253
playerx = 50
playerxmomentum=0
playery = 50
playerymomentum=0
grounded=0
foo = 0
bar = 0
gravity = .981
#MAIN

def draw_player(playerx,playery):
	pygame.draw.rect(screen,RED,[playerx,playery,100,100])
	pygame.draw.rect(screen,WHITE,[playerx+10,playery+10,80,80])
	pygame.draw.rect(screen,BLACK,[playerx+40,playery+30,40,40])
def draw_target(x,y):
	pygame.draw.line(screen,RED,[x-5,y-5],[x+5,y+5],5)
	pygame.draw.line(screen,RED,[x-5,y+5],[x+5,y-5],5)
	pygame.draw.ellipse(screen,BLACK,[x-10,y-10,20,20],5)
	

print("starting main...")
while not done:
	for event in pygame.event.get():
		if event.type == pygame.QUIT:
			done = True
		elif event.type == pygame.KEYDOWN:
			if event.key == pygame.K_SPACE:				
				playerymomentum = -20
			if event.key == pygame.K_LEFT:
				print "move left"
				playerxmomentum = -3
			if event.key == pygame.K_RIGHT:
				print "move right"
				playerxmomentum = 3
				
		elif event.type == pygame.KEYUP:
			if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT:
				playerxmomentum = 0

	#GAME LOGIC

	#DRAWING CODE
	screen.fill(BLUE)
	playerymomentum+=gravity
	if(playery+playerymomentum>400):
		playerymomentum=0
		playery=400
		grounded=1
	else:
		grounded=0
		playery+=playerymomentum
	pygame.draw.rect(screen,GREEN,[0,500,800,100])

	playerx+=playerxmomentum
	draw_player(playerx,playery)

	#pygame.draw.rect(screen,WHITE,[playerx+40,playery+30,40,40])
	pygame.draw.rect(screen,WHITE,[(-200+(foo%1100)),100,200,100])
	pygame.draw.rect(screen,WHITE,[(-200+((foo+400)%1100)),200,200,100])
	pygame.draw.rect(screen,WHITE,[(-200+((foo+800)%1100)),150,200,100])
	pygame.draw.rect(screen,WHITE,[(-200+(foo%1100)),100,200,100])
	pygame.draw.rect(screen,WHITE,[(-200+((foo+550)%1100)),250,200,100])
	#pygame.draw.rect(screen,WHITE,[(-200+((foo+650)%1100)),112,200,100])

	text = font.render(("Frames Rendered: "+str(foo)),True,RED)
	screen.blit(text, [1,1])
	foo+=1
	

	pos = pygame.mouse.get_pos()
	draw_target(pos[0],pos[1])

	#SCREEN UPDATE
	pygame.display.flip()
	#60FPS PCMR
	clock.tick(60)



pygame.quit()

{% endhighlight %}

Neato.

