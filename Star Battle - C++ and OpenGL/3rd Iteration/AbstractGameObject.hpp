#ifndef AbstractGameObject_hpp
#define AbstractGameObject_hpp

#include "ofMain.h"

#include "GameObject.hpp"

class AbstractGameObject : public GameObject {
    protected:
        string spriteName;
        float x, y;
        ofImage sprite;
        bool alive;
    
        virtual void kill();
    public:
        AbstractGameObject(const string& spriteName);
    
        //Proibição da cópia
        AbstractGameObject(const AbstractGameObject&) = delete;
        AbstractGameObject& operator = (const AbstractGameObject&) = delete;
    
        virtual void setup(float x, float y);
        virtual void update(float s);
        virtual void draw() const;
        virtual bool finished();
    
        virtual ofRectangle getBounds() const;
    
        virtual void hit(const GameObject& other);
    
        virtual ~AbstractGameObject();
};

#endif /* AbstractGameObject_hpp */
