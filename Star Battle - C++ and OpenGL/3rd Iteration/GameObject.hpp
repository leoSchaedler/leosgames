#ifndef GameObject_hpp
#define GameObject_hpp

#include "ofMain.h"

class GameObject {
    public:
        virtual void setup(float x, float y) = 0;
        virtual void update(float s) = 0;
        virtual void draw() const = 0;
        virtual bool finished() = 0;
        virtual ofRectangle getBounds() const = 0;
        virtual void hit(const GameObject& other) = 0;
    
        virtual ~GameObject() {};
};

#endif /* GameObject_hpp */
