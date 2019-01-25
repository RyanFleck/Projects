#!/bin/bash
# Runs RUBOCOP on the .rb directory.

echo "Linting Ruby files."
rubocop -a -L --parallel

# echo "Formatting Ruby files."
# rubocop --fix-layout *.rb # Fairly certain -a does this as well. (And more!)
