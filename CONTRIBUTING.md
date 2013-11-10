Contributing
============
Note: The contents of this MD file applies to developers with push access.

Formatting
==========

Your updates to InfectedPlugin must contain proper formatting, please use good formatting as we don't want to correct you.

Style
=====

Instead of using:
```java
if (player.isEpic){
  explode;
}
```
always use:
```java
if (player.isEpic)
{
    explode;
}
```

.commands
=========

Remember, the console can see every command you use, so never create / commands.

Instead, you must go into the "Commands" folder and make a new command class. Or, modify an existing command class.

We use . commands rather than / commands.

Put your features in one pull request
=====================================
It is important that people put their features/fixes in one pull request. This is because if you put all your features/fixes into
one Pull Request, one feature/fix may not be approved so your whole Pull Request with all the other stuff get's denied. Please put your features/fixes into one Pull Request.

.help
=====
Whenever you update/create a command, be sure to update/create the command in Command_help.java!

Branch
======
Always commit to master branch,
When master branch is good enough we will update RB branch.

How
===
To contribute to InfectedPlugin, you must follow the rules for contributing stated above, but you may want to know how to contribute aswell.

First of all, you must fork the project by clicking on the Fork button in the corner of the project, then select your github user.

After it's finished forking InfectedPlugin, you can start editing the code.

After you're done editing the code, you must open up a Pull Request by clicking on the "Pull Request" button.

Click on "New Pull Request" then create the pull request.
