FLAGS = -std=c++11 -O2 -Wall
SRCS = $(wildcard algo_*.cpp)

project: algorithms.h $(SRCS); g++ $(FLAGS) algorithms.h $(SRCS) -o algorithms.o

.PHONY: format
format: ; astyle -A3 *.cpp && rm *.orig

.PHONY: clean 
clean: ; git clean -f -d 
