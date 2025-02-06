#ifndef Shoot_hpp
#define Shoot_hpp

#include "ofMain.h"

class Shoot {
    private:
        float x, y;
        ofImage sprite;
    
    public:
        void setup(float x, float y);
        void update(float s);
        void draw();
        float getY();
};

#endif /* Shoot_hpp */
