
# **Dragon-Proxy**

[![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](http://www.gnu.org/licenses/gpl-3.0)
[![Chat](https://img.shields.io/badge/chat-on%20discord-7289da.svg)](https://discord.gg/CmkxTz2)
Travis: [![TravisCI](https://travis-ci.org/DragonetMC/DragonProxy.svg?branch=master)](https://travis-ci.org/DragonetMC/DragonProxy)
Code-MC: [![Build Status](https://ci.codemc.org/buildStatus/icon?job=DragonetMC/DragonProxy)](https://ci.codemc.org/job/DragonetMC/job/DragonProxy/)


A proxy to allow **Minecraft: Bedrock** clients to connect to **Minecraft: Java Edition** servers.

![Screenshot](https://github.com/DragonetMC/DragonProxy/raw/master/screenshots/hypixel.png)

### What is Dragon-Proxy
DragonProxy is a Bridge placed between a Minecraft Bedrock client and a Java Minecraft server.

Dragon-Proxy is __NOT a plugin__, __OR a server__ It sits in the middle and "translates" (still heavy W.I.P but were working hard to improve it!).

## Features
- Currently supporting Bedrock 1.2.10 and Java 1.12.2
- Chat supported
- Chunks supported
- Movement supported
- Block break / place supported
- Entities spawn move and equipment
- BocksEntities spawn
- Chests




# Download
 - [release](https://github.com/DragonetMC/DragonProxy/releases) : stable builds, standard features
 - [snapshots](https://ci.codemc.org/job/DragonetMC/job/DragonProxy/lastSuccessfulBuild/artifact/proxy/target/)(take first jar) : developments builds, unstable, latest features

## Compiling
clone from github

execute `mvn package` in root project dir

## Setting Up
Check out our [QuickStart](https://github.com/abelj001/DragonProxy/blob/master/README.md#quick-start) Guide!


## Libraries used
* [JRakNet by Whirvis](https://github.com/JRakNet/JRakNet)
* [MCProtocolLib by Steveice10](https://github.com/Steveice10/MCProtocolLib)


## Current job-list 
https://github.com/DragonetMC/DragonProxy/issues/132

## Known bugs/issues
 - No creative inventory
 - Movements on stairs/half blocks
 - with windows 10 sometimes If you try to run Dragon-Proxy on the same computer you start Minecraft W10 Edition on,you may experience problems, if so you must enable [loopback for Minecraft protocol](http://pmmp.readthedocs.io/en/rtfd/faq/connecting/win10localhostcantconnect.html) .
 - __Servers with Certain Anti-cheat Plugins can sometimes register some movements as speed-hacks/flying. **USE AT YOUR OWN RISK!**__
If you get banned from a server, we do not take responsibility!


## Won't fix/implements :
 - Older protocol compatibility (including plugins like ViaVersion)


## Thanks :
* [PocketMine-MP](https://github.com/pmmp/PocketMine-MP)
* [Nukkit](https://github.com/NukkitX/Nukkit)
* [MINET](https://github.com/NiclasOlofsson/MiNET)
* [MinecraftCoalition](http://wiki.vg)

# Looking for a Server host?
[![](https://shockbyte.com/assets/img/logo-2017.png)](https://shockbyte.com/partner/dragonet)
## Get it from [SHOCKBYTE](https://shockbyte.com/partner/dragonet)!! 
#### It supports Dragon-Proxy!
Super powerful servers with affordable price! Decent 👍  

![,](http://www.solidbackgrounds.com/images/2560x1440/2560x1440-white-solid-color-background.jpg)




# Quick-Start!

 ## **Win**

 ### **First Setup**

   Create a new folder and drag your copy of Dragon-Proxy Into it, Then create a new text document in the same folder.

   In the Text Document you just created, Add `java -jar dragonproxy-<version>.jar` to it, Replacing `<version>` with your own, Then go ahead and save it as `start.bat` 

   Double Click on start.bat, and let it create the `config` and `metrics` files, Once done you can then type `stop` in the console to close it

 ### **Adding Your server**

   To connect to a server of your choice, Open `config.yml` And navigate to about line 28 

   Change the address in  `remote_server_addr:` to the address of Your desired Java Edition server

   And then `remote_server_port:` to the desired  Java Servers Port

   Save your File and then Double click on `start.bat` If successful You should see `[INFO] The proxy has started!` Pop up!
    
   ### **Time to test it out!**    
Open up your Win10/PE edition of minecraft And navigate to the `Servers` tab And Type `localhost` You should then connect Into a small box, and a GUI will prompt you to login with your Java edition Credentials, Once logged in, You will be transported to the server you stated in the config, All set! 

## **Shockbyte setup**
Coming soon


##  **Making your server visible to the outside world!**
 To make sure people can connect to your server from outside your local network, You will need to port forward `port:19132 TCP/UDP`on your router, and firewall software, If your new to this You can find router specific Guides [Here](https://portforward.com/router.htm)


# Hybrid Bungee Auth

## How it works
<Hoverepic please explain>
  
  ### Download Bungge + Spigot Plugins
  
   Head over to [CodeMC](https://ci.codemc.org/job/DragonetMC/job/DragonProxy/) And download 
  
  `dragonproxy-plugin-bungee-<version>.jar` and `dragonproxy-plugin-spigot-<version>.jar`
  
  Place Each plugin in there corresponding  plugin folders. and start each instance. 
  
  Navigate to your dragon proxy config and around line 35 there will be a section called `Server Authentication Modes` Change your mode   to `hybrid` and launch dragon proxy as you would normally, No More Typing try it out!🍪
  
