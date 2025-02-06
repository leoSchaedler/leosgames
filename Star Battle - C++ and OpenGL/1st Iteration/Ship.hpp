#ifndef Ship_hpp
#define Ship_hpp

#include "ofMain.h"
#include "Shoot.hpp"

class Ship {
    private:
        float x, y;
        ofImage sprite;
        bool canShoot;
    
    public:
        void setup();
        Shoot* update(float s);
        void draw();
        void enableShoot();
        
}; //<-------

#endif /* Ship_hpp */
