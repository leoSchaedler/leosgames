#ifndef GameObject_hpp
#define GameObject_hpp

class GameManager;

class GameObject {
    public:
        virtual void setManager(GameManager* manager) = 0;
        virtual void setup(float x, float y) = 0;
        virtual void update(float s) = 0;
        virtual void draw() const = 0;
        virtual bool finished() = 0;
        virtual ~GameObject() {};
};

#endif /* GameObject_hpp */
