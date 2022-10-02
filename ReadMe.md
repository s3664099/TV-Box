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

## Requirements

This program runs on Ubuntu and requires Firefox to run. The program will execute command line
processes, namely to launch the browser in Kiosk Mode, and to shut down the machine. These commands
may be specific to Linux, or even Ubuntu.

## Installation and Instructions

The program will run in Eclipse, however for it to work properly it will need to be compiled. 
Compile the program as follows:

*javac *\/\*.java*

Then run the program as follows:

*java Main*

For it to run properly, it will need to be compiled as a jar file. [The following](https://gnomeshell.wordpress.com/2011/08/28/manage-the-startup-applications/) gives instructions on how to set it up.  

The program will need to be configured for your location as it is currently configured for 
Australia. Also, the program hasn't been configured to launch a VPN.

Finally, many of these websites use passwords, and the kiosk mode, as far as I have discovered, will not accept third party password managers. To be able to launch the websites you will need to save your passwords using the browser's password manager. When you launch the webpage using the kiosk mode, the browser will then be able to access your password.

To exit the JFrame without clicking the power off button (which shuts down the computer) press ctrl
while clicking on that same button.

## Code

**MainFrame**

device - This variable gets the details of the screen and stores them to enable full screen mode
         for the application
buttons - A two dimensional array that holds the icon representing the website, and the details of
         the website. If it is not a website, then a single command for the action to be performed
width - the number of columns on the JPanel
height - the number of rows on the JPanel

public MainFrame() - This is the constructor. Here is builds the frame with the buttons based on the 
        height and the width. It also loads the button details and builds the buttons. Then it 
        launches the frame in full screen mode.

private JButton CreateImage(String icon,String webpage) - The function creates the button and passes
        it back to MainFrame to add to the panel. It creates an icon using the ImageIcon class to add 
        to the button as well as adding an ActionListener which performs the action of loading the
        launching the webpage, the video player, or shutting down the computer/program

**LaunchBrowser**

webpage - holds the details of the webpage
button - holds the button
path - the default path in the file system where the videos are located
defaultPlayer - the default video player for the system
fullScreenOption - the command to launch the default player in full screen
browser - the default browser for the system
browserOption - a list of options when the browser is launched

public LaunchBrowser(String webpage, JButton button) - the constructor

public void actionPerformed(ActionEvent e) - standard ActionListener method. Checks if the action
        is to shutdown and whether it is closing the program or shutting down the machine. Otherwise
        the button is disables and the executeCommand is called, passing through the details of the
        webpage.
        
private void shutDown(ActionEvent e) - method that holds the code to shutdown either the computer
        or the program.
        
private void launchVideo() - method that opens a dialogue box at the selected path and launches the
        selected program (video) using the default video player in full screen mode.
        
private void openWebsite() - method that launches the process that opens the website at the selected
        webpage, and disables the button for 10 seconds.

private void openFileSystem() - method that opens the file system at the selected path

private void executeCommand(String cmb) - the command is processed to launch the webpage in firefox
        using kiosk mode.



## Attempts to Create a KeyListener to close the Browser

## Issues
I have not been able to figure out the best way to shut the Kiosk Mode down. At this stage the only
way to shut it down and return to the main program is by pressing ctrl-F4.

## Updates

**Monday 26 Sept 2022**
Moved the details of the buttons into an array, and created a loop to add the buttons to the panel.
Removed the hard coding of the grid layout size.

**Wednesday 28 Sept 2022**
Added a key listener to the JFrame to close the program as a means to escape without shutting down the computer.

**Saturday 1 Oct 2022**
Added shortcut key to kill the program but not shut down the computer. If hold down ctrl and click
on the 'shutdown' button the program will be killed.  Made background colour buttons black. Added
video launcher for smplayer. Disables button for ten seconds when clicked.

**Sunday 2 Oct 2022**
Added button to open the file system (to be able to search for videos) and created some private
methods in LaunchBrowser. Moved hardcoded strings out of function calls in launch browser and
placed them at top of class.

## To Do
1. Fix issue with IllegalComponentStateException when closing
2. Add a process to launch the default VPN in the background.

