#ifndef GameManager_hpp
#define GameManager_hpp


#include <vector>

#include "GameObject.hpp"

class GameManager {
    private:
        std::vector<GameObject*> objects;
    
    public:
        void add(GameObject* object);
        void setup();
        void update();
        void draw() const;
};



#endif /* GameManager_hpp */
