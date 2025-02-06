#include "AbstractGameObject.hpp"

#include <random>

#ifndef Missile_hpp
#define Missile_hpp

class Alien;

class Missile : public AbstractGameObject {
    private:
        Alien* target;
        std::mt19937 mt;
    public:
        Missile();
        virtual void setup(ofVec2f pos) override;
        virtual void update(float s) override;
        virtual void hit(const GameObject& other) override;
};

#endif /* Missile_hpp */
