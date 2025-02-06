#ifndef GameObject_hpp
#define GameObject_hpp

#include "ofMain.h"

class GameObject {
    public:
        virtual void setup(ofVec2f pos) = 0;
        virtual void update(float s) = 0;
        virtual void draw() const = 0;
        virtual bool finished() const = 0;
    
        virtual ofVec2f getPos() const = 0;
        virtual ofRectangle getBounds() const = 0;
        virtual void hit(const GameObject& other) = 0;
        
    
        virtual ~GameObject() {};
};

#endif /* GameObject_hpp */
