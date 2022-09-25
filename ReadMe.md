# TV-Box
**Author**: David Sarkies
**Version**: 1.0
**Date**: 25 September 2022

## Introduction
This program is designed to turn a machine into a smart TV. The idea is that it creates a JPanel
that contains buttons that will launch a video streaming site in Kiosk Mode. The JPanel is designed
to run in full screen mode and will launch upon start up. A power off button is included that will
shut the machine down when it is pressed. The idea is that the machine will only run this program
and the browser that is used to display the webpages.

##Requirements
This program runs on Ubuntu and requires Firefox to run. The program will execute command line
processes, namely to launch the browser in Kiosk Mode, and to shut down the machine. These commands
may be specific to Linux, or even Ubuntu.

## Installation
The program will run in Eclipse, however for it to work properly it will need to be compiled. 
Compile the program as follows:

*javac *\/\*.java*

Then run the program as follows:

*java Main*

For it to run properly, it will need to be compiled as a jar file. [The following](https://gnomeshell.wordpress.com/2011/08/28/manage-the-startup-applications/) gives instructions on how to set it up.  

The program will need to be configured for your location as it is currently configured for 
Australia. Also, the program hasn't been configured to launch a VPN.

##Code
**MainFrame**

**LaunchBrowser**

**ProcessKill**

**ShutDownBrowser**

##Attempts to Create a KeyListener to close the Browser

##Issues
I have not been able to figure out the best way to shut the Kiosk Mode down. At this stage the only
way to shut it down and return to the main program is by pressing ctrl-F4.

##To Do
1. Refactor Code to make it more configurable. Remove hard coded numbers, and hard coded images and webpages. Write it so that another may be able to change the number of buttons and the webpages.
2. Add blank buttons for buttons not being used.
3. Add a process to select a video and launch it using the default video player
4. Add a process to launch the default VPN in the background.

