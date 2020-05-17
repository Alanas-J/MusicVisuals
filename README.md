# Music Visualiser Project

Name: Alanas Jakubauskas

Student Number: C18473312

![img1](https://i.imgur.com/cZgB6ce.jpg)
![img2](https://i.imgur.com/uUtnOvk.png)

# Description of the assignment

My Visual Assignment is a music playing audio visualuzer with a click based GUI with two new self made visuals ontop of the example visuals given in the lab test which can be cycled through at any time.


INZO - Overthinker : a song with Alan Watts samples is used for some extra brownie points.



# Instructions

Just click, no hidden keybinds.


# How it works

It's a simple processing program which features a switch controlled by the second processing window to start the music and swap between the given example visuals and two of my own made visuals.

I was trying to go for a windows XP inspired media player visual for the first one, but it didn't work out looking too much like that visual still nice.

My favourite was definitely the tree fractal as it's simple yet cause of the nature of fractals infinite to an extent.

Then did a few adjustments to the waveform visual to expand it to the bigger window size of my project using a modulo operator to make it look like the audio buffer is big enough to fit the window.

# What I am most proud of in the assignment

I coded the fractal tree last day before the assignment deadline along with the clickbased GUI another day before.

The most satisfying aspect by far was making my own implementation of a object oriented fractal tree with some inspiration from the Coding Train youtube channel, a channel I've been following for fun for a while. Since that tutorial was in javascript using P5.js it wasn't too useful apart from giving a general concept on what a fractal tree. Which is a branch/stump which has 2 or more children connecting from the top which then take the same property of having children. This is the basis of fractals which are self similar shapes with the fractal tree being one of the easiest ways to thing about fractals and recursion.

The first working fractal tree after many errors, since recursion can be confusing to work with :
![basic fractal tree](https://i.imgur.com/lF49lls.png)



For my rendition I utilised function recursion and the built in processing drawing matrix functions in order to translate and rotate each element, minimising the ammount of thought needed for coordinate geometry and making me not require to do my own matrix multiplication. This came at a small con which the the limitations of 32 pushes onto the matrix stack. But this is more than enough for a fractal tree.

 Also since its object oriented with more time more characteristics and visuals to each tree branch could've been made
There's also alot cooler things to do with fractals not explored : 
![copy distored tree](https://i.imgur.com/UX58t6A.png)

The next thing of pride was inspired by a previous student's video in which they created an alot more advanced interface. But with my lack of discipline during the corona and being swamped with other assignment deadlines 3 days before this I enjoyed my little controller addition. It was nice to learn about how object interraction may be implemented between two objects by having one object reference pass into the other's constructor so that it may be influenced.

Another little cool this was making the processing copy function into a shaking tool via applying some 2D matrix translation calculations.

This is an image using an absolute URL:



YOUTUBE VIDEO :

[![YouTube](https://www.youtube.com/watch?v=wkndoSFnlQY)]

This is a table:

