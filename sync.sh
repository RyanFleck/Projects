#!/bin/bash
echo "Synchronizing git repo."


git add .
git status
git commit -m "Timed sync. Updated Java folder."
git push
