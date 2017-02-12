package com.tanvirsingh.essentiallinuxguide;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class article extends AppCompatActivity {

    String[] generalInfoAboutLinux = {"00","General Information About Linux", "Linux is an operating system just like Microsoft's Windows and Apple's MacOS.\n" +
            "\n" +
            "Linux has different versions for any kind of user - from beginners to professionals, there's one for everyone! These versions are called distributions (or distros). A few popular ones are for the desktop are:\n" +
            "\n" +
            "\tUbuntu\n" +
            "\tLinux Mint\n" +
            "\tDebian\n" +
            "\tFedora\n" +
            "\tArch Linux\n" +
            "\tGentoo Linux\n" +
            "\nYou can discover other distributions here : https://distrowatch.com/\n" +
            "\n" +
            "If you're new to Linux - whether you're a Windows or a Mac user - go with Ubuntu. You'll feel right at home. Then you can move on to Debian or Fedora.\n" +
            "\n" +
            "If you have some previous experience with the shell or Linux itself, try going with Gentoo or Arch. You can't go wrong either way. I advise you to research well before you take the plunge!"};

    String[] whyUseLinux = {"01","Why use Linux?\n", "Who uses Linux anyways?\n" +
            "\n" +
            "I mean, a handful of computers are bundled with a Linux OS like Ubuntu. The rest of world runs on Windows and Macs, right?\n" +
            "\n" +
            "Not exactly\n" +
            "\n" +
            "More than 99% of the supercomputers of the world run on Linux - performing mathematical and scientific calculations and research, crytography and data analysis.\n" +
            "\n" +
            "The servers serving you websites from across the world - 70% of them run Linux or some version of UNIX.\n" +
            "\n" +
            "Your shiny new Android phone runs Linux under the hood.\n" +
            "\n" +
            "The world's smallest computer - the Raspberry Pi runs Linux.\n" +
            "\n" +
            "Heck, so many smart devices/network connected smart devices like fridges, coffee makers run on Linux!\n" +
            "\n" +
            "If you go ahead and Google why you should switch to Linux this is pretty much what you get:\n" +
            "\n" +
            "Its free. Yeah, I forgot to mention that.\n" +
            "\nYou don't need an anti-virus. Been using it for more than 5 years. Never got a virus.\n" +
            "\nGot an old computer? Windows drags itself on it, right? Try Linux.\n" +
            "\nAmazing software. Linux OSs comes with their repositories so you don't need to hunt the internet for anything and run the risk of downloading malware. Did I mention this software has been tested thoroughly?\n" +
            "\nSo why wouldn't you?"};

    String[] howToUseThisGuide = {"02","How to use this guide?","This guide is primarily based around Ubuntu - a beginner friendly Linux Distribution. Almost 99% of the things mentioned in this guide do apply to other distributions as well, the rest 1% focuses on some Ubuntu specific features to help new learners adapt to it easily.\n" +
                    "\n" +
                    "The reason for choosing Ubuntu as a reference system is the massive online commmunity and forums for solving every little problem that you are bound to encounter.\n" +
                    "\n" +
                    "Readers are encouraged to:\n" +
                    "\n" +
                    "Spend most of their time in Linux - even doing day to day activities like listening to music or browsing the web.\n" +
                    "\n" +
                    "Make forums like AskUbuntu (StackOverflow), the Linux Subreddit and the Ubuntu Subreddit part of their daily reading routine.\n" +
                    "\n" +
                    "Break stuff and try to fix it. Google and Stack Overflow are your best friends.\n" +
                    "\n" +
                    "Try to customize the machine to their liking.\n" +
                    "\n" +
                    "Install new things and figure out why if they don't work.\n" +
                    "\n" +
                    "Make Linux/Ubuntu their main development machine."};

    String[] introToTerminal = {"10","Introduction to the terminal", "Most of us are used to Graphical User Interfaces (GUIs) - Menus, File explorers, buttons - to do stuff for us.\n" +
                    "\n" +
                    "The shell/Terminal is a CLI (command line interface) takes your input from the keyboard in the form of commands, their attributes and parameters. Once upon a time, this was the only form of entry.\n" +
                    "\n" +
                    "Launch the terminal/shell\n" +
                    "\n" +
                    "You'll find the terminal listed in the applications. On Ubuntu, you can press Ctrl + Alt + T to bring it up.\n" +
                    "\n" +
                    "You'll see something like this:\n" +
                    "\n" +
                    "[myName@myComputersName ~]$\n" +
                    "You can't get rid of this by pressing the backspace. This string of text is actually giving you some pretty important information.\n" +
                    "\n" +
                    "myName- This is the username which is currently logged in. Try making another user and switch to it. It'll change to anotherUser@myComputersName when you're logged in as anotherUser.\n" +
                    "\n" +
                    "myComputerName - This is the name of the machine. This can be something you like or localhost.\n" +
                    "\n" +
                    "@ - The text before this is the user logged in and the text after is the machine.\n" +
                    "\n" +
                    "$ - This dollar means a normal user (% in some systems). You want to be extra careful if this symbol is # instead of $ or %. That means you're running as root (Covered later).\n" +
                    "\n" +
                    "~ - This means you're in the home directory. This is will be replaced by the current lowest directory you're working in (covered below in detail)."};

    String [] basicCommands = {"11","Basic Commands", "Now that you know what's in front of you, let's begin with some basic commands!\n" +
            "\n" +
            "Navigation\n" +
            "\n" +
            "pwd - Print working directory. Type pwd and press enter. The output should be something like this:\n" +
            "\n" +
            "/home/Jack\n" +
            "ls - List Command This command lists all the contents of the directory.\n" +
            "\n" +
            "\nls\n" +
            "cd - Change Directory This command accepts the folder name or the path to one to make the said folder the working directory.\n" +
            "\n" +
            "cd Downloads\n" +
            "\n" +
            "cd /\n" +
            "\n" +
            "cd /bin\n" +
            "\n mkdir - Make Directory This command makes a directory with the specified name. If the name of the folder is not entered it will throw an error.\n" +
            "\nmkdir linux\n" +
            "rm - Remove Directory The rm command deletes a file or a directory.\n" +
            "To delete a file:\n" +
            "\n" +
            "\nrm filename.fileExtension\n" +
            "To delete a folder:\n" +
            "\n" +
            "rm -d folderName\n" +
            "File Manipulation\n" +
            "\n" +
            "touch - Create a file. The ‘touch’ command creates an empty file with the name and extension mentioned (or not).\n" +
            "touch hello\n" +
            "\n" +
            "touch index.html\n" +
            "\n" +
            "touch install.sh\n" +
            "mv - Move command (also rename command) mv is used to move a file or directory from one location to another or just rename the file.\n" +
            "Move File:\n" +
            "\n" +
            "mv index.html /www/root/\n" +
            "Rename File:\n" +
            "\n" +
            "mv index.html index1.html\n" +
            "cp - Copy command cp is used to copy a file or directory from one location to another or just create a new file with a new name and the same content.\n" +
            "Copy File -\n" +
            "\n" +
            "cp index.html /someFolder cp index.html index1.html (Creates another file with the same contents)\n" +
            "Copy Directory -\n" +
            "\n" +
            "cp -R directoryName /FolderTo/CopyTo cp -R directoryOriginalName DirectoryCopyName (Creates a new directory with a new name)\n" +
            "cat - Display the contents of a file in the terminal\n" +
            "Example:\n" +
            "\n" +
            "cat index.html\n" +
            "\n" +
            "cat helloworld.c\n" +
            "\n" +
            "cat hack.py\n" +
            "nano or vim - a text editor to create or edit files\n" +
            "nano index.html\n" +
            "\n" +
            "vim index.html\n" +
            "If the file doesn't exist, nano or vim will create it for you. If it exists, nano or vim will open it for you to edit it."};

    String[] howtoInstallApps = {"12","How do I install applications?", "There are 2 ways to install software packages on Ubuntu:\n" +
                    "\n" +
                    "1. From the Internet\n" +
                    "\n" +
                    "Installing applications in your favorite Linux Distro is pretty simple but before we do that, you need to know what a repository (repo) is.\n" +
                    "\n" +
                    "According to Wikipedia,\n" +
                    "\n" +
                    "A software repository is a storage location from which software packages may be retrieved and installed on a computer.\n" +
                    "Ubuntu (and some other Distros) comes pre-configured with some software repositories from where you can install applications.\n" +
                    "\n" +
                    "If some software isn't hosted (stored) on the default software repositories, you can always add one (a Google search will be helpful when you encounter such a situation).\n" +
                    "\n" +
                    "If you're installing for the first time on your system or just added a new repo, you should run this command:\n" +
                    "\n" +
                    "sudo apt-get update\n" +
                    "Then you can install any software that's in the repository by entering:\n" +
                    "\n" +
                    "sudo apt-get install software_name\n" +
                    "Example to install vlc:\n" +
                    "\n" +
                    "sudo apt-get install vlc\n" +
                    "Note: On entering either of these commands you will be asked to enter the root password. You will not be able to install anything till you enter it.\n" +
                    "\n" +
                    "EXPLORE:\n" +
                    "\n" +
                    "Readers are encouraged to search on how to add a software repository. For example you will need to add a repository (PPA) to install Sublime Text (a text editor)\n" +
                    "\n" +
                    "2. From a package file\n" +
                    "\n" +
                    "If you've downloaded a .deb file from the internet, it can be used to install the software.\n" +
                    "\n" +
                    "First, cd to the location where the file is. For this example, its in the downloads folder:\n" +
                    "\n" +
                    "cd Downloads\n" +
                    "Then to install the package we'll use the dpkg command:\n" +
                    "\n" +
                    "sudo dpkg –i filename.deb\n" +
                    "Install packages from a tarball\n" +
                    "Readers are encouraged to research and find a solution when they encounter such a situation."};

    String[] manpages = {"13","man pages\n", "Linux has an in-built software documentation for commands, system calls and library calls. This can help read in depth about commands, their attributes and usage.\n" +
            "\n" +
            "This software documentation is called manual page (man page). To get the manual page for a command you type :\n" +
            "\n" +
            "man command_name\n" +
            "Examples:\n" +
            "\n" +
            "man ls\n" +
            "\n" +
            "man cp\n" +
            "\n" +
            "man nano\n" +
            "The man command returns the following:\n" +
            "\n" +
            "NAME The name of the command or function, followed by a one-line description of what it does.\n" +
            "SYNOPSIS In the case of a command, a formal description of how to run it and what command line options it takes. For program functions, a list of the parameters the function takes and which header file contains its definition.\n" +
            "DESCRIPTION A textual description of the functioning of the command or function.\n" +
            "EXAMPLES Some examples of common usage.\n" +
            "SEE ALSO A list of related commands or functions."};

    String[] commandLineArguments = {"14","Command Line Arguments and How To Use Them", "As you use Linux, you'll realize the need of extra information when dealing with files and even hardware or just executing something specific.\n" +
            "\n" +
            "Enter Command Line Arguements.\n" +
            "\n" +
            "We'll be taking the example of the ls command to demonstrate the power of Command Line Arguments. Say you enter ls, this is what you generally get:\n" +
            "\n" +
            "gulp.pdf index.php myfile script.js script.py\n" +
            "This is just the list of files that are visible with no extra information.\n" +
            "\n" +
            "Say you want to see the hidden files as well (hidden files start a dot [.]), you type\n" +
            "\n" +
            "ls -a\n" +
            "This is what is returned\n" +
            "\n" +
            ". .. gulp.pdf .hidden index.php myfile script.js script.py\n" +
            "Say you want the list in reverse order, type\n" +
            "\n" +
            "ls -r\n" +
            "The list is returned in the reverse order\n" +
            "\n" +
            "script.py script.js myfile index.php gulp.pdf\n" +
            "You can also club 2 arguments togerther to apply both of them to the output:\n" +
            "\n" +
            "ls -ar\n" +
            "\n" +
            "script.py script.js myfile index.php .hidden gulp.pdf .. .\n" +
            "You can also get the list in the long listing format by typing:\n" +
            "\n" +
            "ls -l\n" +
            "This returns:\n" +
            "\n" +
            "total 100\n" +
            "\n" +
            "-rw-r--r-- 1 myname users 99485 Dec 18 15:43 gulp.pdf\n" +
            "\n" +
            "-rwx------ 1 myname users 0 Jan 6 04:44 index.php\n" +
            "\n" +
            "-rw-r--r-- 1 myname users 0 Dec 20 18:17 myfile\n" +
            "\n" +
            "-rw-r--r-- 1 myname users 0 Jan 6 04:44 script.js\n" +
            "\n" +
            "-rw-r--r-- 1 myname users 0 Jan 6 04:44 script.py\n" +
            "Explained for the first file:\n" +
            "\n" +
            "-rw-r--r-- permissions\n" +
            "\n" +
            "1 : number of linked hard-links\n" +
            "\n" +
            "myname: owner of the file\n" +
            "\n" +
            "users: to which group this file belongs to\n" +
            "\n" +
            "99485: size\n" +
            "\n" +
            "Dec 18 15:43 modification/creation date and time\n" +
            "\n" +
            "gulp.pdf: file/directory name\n" +
            "\n" +
            "How do you get to know about arguments then? Do you Google them? What about when you don't have internet?\n" +
            "\n" +
            "man pages!\n" +
            "\n" +
            "man pages have information on everything about the command as well as their commands. Check out the above linked page for information about man pages."};

    String[] preinstalledCompilers = {"20","Pre installed Compilers and Interpreters", "Most Linux distributions come with compilers and interpreters of various programming languages pre-installed. Some standard ones are:\n" +
                    "\n" +
                    "GCC compiler- to compile all your \"c\" programs. You can install the g++ compiler for compiling C++ programs.\n" +
                    "\n" +
                    "Python - Most Linux Distros include both - the Python 2 and Python 3 - interpreters.\n" +
                    "\n" +
                    "Perl\n" +
                    "\n" +
                    "Python and Perl are supposed to be there because many system utilities and scripts are written in or depend on either of those two."};

          String[] textEditors = {"21","Text Editors\n", "Linux is heavily reliant on files - from configuration to viewing information. Hence, having control over them is important.\n" +
                  "\n" +
                  "That's where text editors come in. nano and vim (or vi depending on your distribution) are 2 editors which work inside the terminal.\n" +
                  "\n" +
                  "nano\n" +
                  "Nano is probably a more beginner friendly text editor with pretty straightforward use. There isn't much of a learning curve.\n" +
                  "\n" +
                  "To open an existing file and edit it:\n" +
                  "\n" +
                  "nano file.txt\n" +
                  "To create a file which doesn't exist and open it for editing:\n" +
                  "\n" +
                  "nano file.txt\n" +
                  "nano heavily relies on the control key (ctrl) - using it with letters to run commands written at the bottom of the text editor. For example : ^X means ctrl + x\n" +
                  "\n" +
                  "To save the file:\n" +
                  "\n" +
                  "ctrl + o\n" +
                  "To exit nano:\n" +
                  "\n" +
                  "ctrl + x\n" +
                  "To find something in the file:\n" +
                  "\n" +
                  "ctrl + w\n" +
                  "These are some of the basic options. The rest are for the reader to explore as per their requirement.\n" +
                  "\n" +
                  "vim\n" +
                  "vim is a popular editor in the *nix community (having started wars with people using emacs)\n" +
                  "\n" +
                  "Here's an amazing tutorial to learn vim:\n" +
                  "\n" +
                  "http://www.openvim.com/\n" +
                  "\n" +
                  "You can also install \"vimtutor\" on your machine to get a tutorial inside the terminal.\n"};
    String subTopicString;
    TextView article;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        subTopicString = getIntent().getExtras().getString("SubTopic");

        SharedPreferences prefs = getSharedPreferences("fromBasics", MODE_PRIVATE);
        String restoredText = prefs.getString("basicsTopic", null);

        Log.d(TAG, "Received " + restoredText + " from Basics topic.");
        Log.d(TAG, "Received " + subTopicString + " from subtopic");

        String articleID =  restoredText + subTopicString;

        Log.d(TAG, "Article ID is : " + articleID);

        article = (TextView) findViewById(R.id.article);

        if (articleID.equals("00")) {

            article.setText(generalInfoAboutLinux[2]);
            setTitle(generalInfoAboutLinux[1]);

        } else if (articleID.equals("01")) {

            article.setText(whyUseLinux[2]);
            setTitle(whyUseLinux[1]);

        } else if (articleID.equals("02")) {

            article.setText(howToUseThisGuide[2]);
            setTitle(howToUseThisGuide[1]);

        } else if (articleID.equals("10")) {

            article.setText(introToTerminal[2]);
            setTitle(introToTerminal[1]);

        } else if (articleID.equals("11")) {

            article.setText(basicCommands[2]);
            setTitle(basicCommands[1]);

        } else if (articleID.equals("12")) {

            article.setText(howtoInstallApps[2]);
            setTitle(howtoInstallApps[1]);

        } else if (articleID.equals("13")) {

            article.setText(manpages[2]);
            setTitle(manpages[1]);

        } else if (articleID.equals("14")) {

            article.setText(commandLineArguments[2]);
            setTitle(commandLineArguments[1]);

        } else if (articleID.equals("20")) {

            article.setText(preinstalledCompilers[2]);
            setTitle(preinstalledCompilers[1]);

        } else if (articleID.equals("21")) {

            article.setText(textEditors[2]);
            setTitle(textEditors[1]);
        };
    }

}
