#!/bin/bash
echo "Synchronizing git repo."
git status
git add .
git commit -m "Timed sync. Updated Java folder."
git push
