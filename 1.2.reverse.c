// Cracking the Coding Interview 1.2
// Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated string.

#include <stdio.h>

void reverse(char* str) {
	if (str == NULL) {
		return;
	}

	char* end = str;
	while (*end != '\0') {
		end++;
	}
	end--;

	char tmp;
	while (str < end) {
		tmp = *str;
		*str++ = *end;
		*end-- = tmp;
	}
}
