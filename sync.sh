#!/bin/bash
echo "Synchronizing git repo. Commit message: '$1':."

if [[ -z $1 ]]; 
then
	echo "No input. Using default commit message."
	MSG="Automatic bash-script commit."
else
	MSG=$1
fi

git pull
git add .
git status
git commit -m "$MSG"
git push
