#!/bin/bash

# Git auto-config for Ryan Fleck.

git config --global user.name "Ryan Fleck"
git config --global user.email "ryan.fleck@protonmail.com"
git config --global core.editor vim
git config --global credential.helper 'cache --timeout=7200'
echo ""
echo "Saved git settings:"
git config --list
