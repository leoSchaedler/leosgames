#ifndef Alien_hpp
#define Alien_hpp

#include "AbstractGameObject.hpp"

class Alien : public AbstractGameObject {
    private:
        bool isTarget;
    public:
        Alien();
        virtual void draw() const override;
        virtual void hit(const GameObject& other) override;
        void flipTarget();
    
};

#endif /* Alien_hpp */
