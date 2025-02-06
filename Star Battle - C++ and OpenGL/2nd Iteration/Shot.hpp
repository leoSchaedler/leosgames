#include "AbstractGameObject.hpp"

#ifndef Shot_hpp
#define Shot_hpp

class Shot : public AbstractGameObject {
    public:
        Shot();
        void update(float s) override;
        bool finished() override;
};

#endif /* Shot_hpp */
