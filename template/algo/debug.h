#undef _GLIBCXX_DEBUG

#ifndef DEBUG_H
#define DEBUG_H

#include <iostream>

#define debug(x) std::cerr << #x << ": " << x << std::endl;

#define assert(cond)                                                                                                   \
    do {                                                                                                               \
        if (!(cond)) {                                                                                                 \
            exit(0);                                                                                                   \
        }                                                                                                              \
    } while (0)

#endif // DEBUG_H
