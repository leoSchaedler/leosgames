#include "AbstractGameObject.hpp"

#ifndef Shot_hpp
#define Shot_hpp

class Shot : public AbstractGameObject {
    public:
        Shot();
        virtual void update(float s) override;        
        virtual void hit(const GameObject& other) override;
};

#endif /* Shot_hpp */
