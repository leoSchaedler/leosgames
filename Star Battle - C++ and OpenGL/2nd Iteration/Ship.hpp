#ifndef Ship_hpp
#define Ship_hpp

#include "Shot.hpp"

class Ship : public AbstractGameObject {
    private:
        float interval;

    public:
        Ship();
        void update(float s);        
};

#endif /* Ship_hpp */
