#ifndef Ship_hpp
#define Ship_hpp

#include "AbstractGameObject.hpp"

class Ship : public AbstractGameObject {
    private:
        float interval;
        float missileInterval;

    public:
        Ship();
        void update(float s);        
};

#endif /* Ship_hpp */
