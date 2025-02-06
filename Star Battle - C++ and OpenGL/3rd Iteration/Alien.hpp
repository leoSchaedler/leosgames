#ifndef Alien_hpp
#define Alien_hpp

#include "AbstractGameObject.hpp"

class Alien : public AbstractGameObject {
    public:
        Alien();
        virtual void hit(const GameObject& other) override;
    
};

#endif /* Alien_hpp */
