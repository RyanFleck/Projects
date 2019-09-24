#!/usr/bin/python3

import os


def crawlAndPullRepos():
    issue_dirs = []
    for dirname, subdirs, filenames in os.walk(os.getcwd()):
        if '.git' in subdirs:
            print("\nDirectory " + dirname + " is a git repository.")
            output = os.system("cd " + dirname + " && git pull")
            if(output != 0):
                issue_dirs.append(dirname)

    if(len(issue_dirs) > 0):
        x = 0
        print('\nErrors were thrown when attempting to pull ' +
              str(len(issue_dirs)) + ' repositories:')
        for repo in issue_dirs:
            x = x + 1
            print('\t' + str(x) + ': ' + repo)


crawlAndPullRepos()
