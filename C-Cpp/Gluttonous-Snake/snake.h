void clear_snake();
int out_of_table(int x,int y);
int eat_self(int x,int y);
void eat_food(int x,int y);
void move(int x,int y);
void creat_food();
int random(int seed);
void new_game();
void run_game();
void draw_table();
void paint();
void key_down(WPARAM wParam);
void resize();
void initialize();
void finalize();
LRESULT CALLBACK WndProc(HWND hwnd,UINT message, WPARAM wParam,LPARAM lParam);
