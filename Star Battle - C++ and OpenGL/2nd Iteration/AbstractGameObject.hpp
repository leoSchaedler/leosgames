#ifndef AbstractGameObject_hpp
#define AbstractGameObject_hpp

#include "ofMain.h"

#include "GameManager.hpp"
#include "GameObject.hpp"

class AbstractGameObject : public GameObject {
    protected:
        GameManager* manager;
        string spriteName;
        float x, y;
        ofImage sprite;
    
    public:
        AbstractGameObject(const string& spriteName);
    
        //Proibição da cópia
        AbstractGameObject(const AbstractGameObject&) = delete;
        AbstractGameObject& operator = (const AbstractGameObject&) = delete;
    
        virtual void setManager(GameManager* manager);
        virtual void setup(float x, float y);
        virtual void update(float s);
        virtual void draw() const;
        virtual bool finished();
        virtual ~AbstractGameObject();
};

#endif /* AbstractGameObject_hpp */
