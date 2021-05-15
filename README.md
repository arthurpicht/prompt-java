# prompt-java

A rich bash prompt written in java

## Executive summary

This project can be seen as a feasibility test for a rich bash prompt programmed in (yes!) java and compiled
to a native binary by graalVM.

## Features

... TODO

## Build

### Prerequisites

* gradle
* graalVM including installation of module for compiling to native
* modify `build.gradle` to match local graalVM installation

### Execute Build

    gradle nativeImage

## Install

Copy `build/native/prompt` to `/usr/local/bin/prompt` and make it is executable for all if necessary.

Configure in your `~/.bahrc`

    PS1="\$(prompt \$?)"

Backslashes before $ make them escaped and prevent immediate execution. 
Value of PS1 is executed as command each time prompt string is requested.
