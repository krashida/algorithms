CXX=g++-6
CXXFLAGS=-std=c++17 -g
LDFLAGS=
ASAN_FLAGS=-fsanitize=address -fno-omit-frame-pointer

LIBS=
ASAN_LIBS=-lasan
# Since our test code has main in file, we have a generic rule to build binary each .cpp. 
# Since % would match any, we cannot use as a generic rule for building binary files, hence have explicitly added .out extension.
src=$(wildcard *.cpp)
bin=$(src:.cpp=.out)

#.SECONDARY helps to not delete intermediatary files like .o etc.
.SECONDARY:
.PHONY: all clean
all: $(bin)

%.out: %.o
	$(CXX) -o $@ $^ $(LDFLAGS) $(LIBS) $(ASAN_LIBS)

%.o: %.cpp
	$(CXX) $(CXXFLAGS) $(ASAN_FLAGS) -o $@ -c $<

# - ahead of rm indicates to continue even if rm fails for a particular file.
clean:
	-rm -v *.out *.o
