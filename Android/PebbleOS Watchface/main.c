#include <pebble.h>

static Window *s_main_window;
static TextLayer *s_time_layer;
static TextLayer *s_status_layer;
static TextLayer *s_status_layer2;
static Layer *eye_white;
static GRect bounds;
static int lx,ly,rx,ry;


//BLUETOOTH CONNECTION SECTION
static void bluetooth_callback(bool connected) {
  
  #if defined(PBL_COLOR)
  window_set_background_color( s_main_window, GColorVeryLightBlue);
  #elif defined(PBL_BW)
  window_set_background_color( s_main_window, GColorDarkGray);
  #endif
  
  if(!connected) {
    vibes_double_pulse();
    #if defined(PBL_COLOR)
    window_set_background_color( s_main_window, GColorRed);
    #elif defined(PBL_BW)
    window_set_background_color( s_main_window, GColorWhite);
    #endif
    
  }
}

static void update_time() {

  time_t temp = time(NULL); 
  struct tm *tick_time = localtime(&temp);

  static char s_buffer[8];
  strftime(s_buffer, sizeof(s_buffer), clock_is_24h_style() ? "%H %M" : "%I %M", tick_time);
  
  static char date_buffer[16];
  strftime(date_buffer, sizeof(date_buffer), "%b %d", tick_time);
  
  static char date_buffer2[16];
  strftime(date_buffer2, sizeof(date_buffer2), "%a", tick_time);
  
  text_layer_set_text(s_status_layer, date_buffer2);
  text_layer_set_text(s_status_layer2, date_buffer);
  text_layer_set_text(s_time_layer, s_buffer);
}

static void canvas_update_proc(Layer *layer, GContext *ctx) {
  graphics_context_set_stroke_color(ctx, GColorWhite); 
  graphics_context_set_fill_color(ctx, GColorWhite); 
  
  graphics_context_set_stroke_width(ctx, 6); // line width
  graphics_context_set_antialiased(ctx, true); //antialiasing
  
  GPoint center = GPoint((bounds.size.w/2),(bounds.size.h/2));
  uint16_t radius = 5;
  int width = 1;
  for(radius=10;radius<200;radius=radius+14){
    width++;
    graphics_context_set_stroke_width(ctx, width); // line width
    graphics_draw_circle(ctx, center, radius);
    }
  graphics_context_set_fill_color(ctx, GColorBlack); 
  graphics_fill_rect(ctx, GRect(lx+5,ly+5,rx+5,ry+5), 10, GCornersAll);
  
  graphics_context_set_fill_color(ctx, GColorWhite); 
  graphics_fill_rect(ctx, GRect(lx,ly,rx,ry), 10, GCornersAll);
}

static void tick_handler(struct tm *tick_time, TimeUnits units_changed) {
  update_time();
}

static void main_window_load(Window *window) {
  Layer *window_layer = window_get_root_layer(window);
  bounds = layer_get_bounds(window_layer);

   //Clock
  s_time_layer = text_layer_create(GRect(lx,ly,rx,ry-10));
  text_layer_set_background_color(s_time_layer, GColorClear);
  text_layer_set_text_color(s_time_layer, GColorBlack);
  text_layer_set_text(s_time_layer, "00 00");
  text_layer_set_font(s_time_layer, fonts_get_system_font(FONT_KEY_LECO_42_NUMBERS));
  text_layer_set_text_alignment(s_time_layer, GTextAlignmentCenter);
  
  //TOP STATUS
  s_status_layer = text_layer_create(GRect(0, 0, bounds.size.w, 20));
  text_layer_set_background_color(s_status_layer, GColorBlack);
  text_layer_set_text_color(s_status_layer, GColorWhite);
  text_layer_set_text(s_status_layer, "000");
  text_layer_set_font(s_status_layer, fonts_get_system_font(FONT_KEY_GOTHIC_14));
  text_layer_set_text_alignment(s_status_layer, GTextAlignmentCenter);
  
  //BOTTOM STATUS
  s_status_layer2 = text_layer_create(GRect(0, (bounds.size.h - 20), bounds.size.w, (bounds.size.h)));
  text_layer_set_background_color(s_status_layer2, GColorBlack);
  text_layer_set_text_color(s_status_layer2, GColorWhite);
  text_layer_set_text(s_status_layer2, "Date");
  text_layer_set_font(s_status_layer2, fonts_get_system_font(FONT_KEY_GOTHIC_14));
  text_layer_set_text_alignment(s_status_layer2, GTextAlignmentCenter);
  
  //Eye White
  eye_white = layer_create(bounds);
  layer_set_update_proc(eye_white, canvas_update_proc);
  
  
  // Add children
  layer_add_child(window_get_root_layer(window), eye_white);
  layer_add_child(window_layer, text_layer_get_layer(s_time_layer));
  layer_add_child(window_layer, text_layer_get_layer(s_status_layer));
  layer_add_child(window_layer, text_layer_get_layer(s_status_layer2));
  
  ///BLUETOOTH
  bluetooth_callback(connection_service_peek_pebble_app_connection());
  
  
}

static void main_window_unload(Window *window) {
  text_layer_destroy(s_time_layer);
}


static void init() {
  s_main_window = window_create();
  #if defined(PBL_COLOR)
  window_set_background_color( s_main_window, GColorVeryLightBlue);
  #elif defined(PBL_BW)
  window_set_background_color( s_main_window, GColorDarkGray);
  #endif
  window_set_window_handlers(s_main_window, (WindowHandlers) {
    .load = main_window_load,
    .unload = main_window_unload
  });
  
  int basex=PBL_IF_ROUND_ELSE(90, 72);
  int basey=PBL_IF_ROUND_ELSE(90, 82);
  lx=(basex)-70;
  ly=(basey)-55;
  rx=(basex)-15;
  ry=(basey)+20;

  window_stack_push(s_main_window, true);

  update_time();

  tick_timer_service_subscribe(MINUTE_UNIT, tick_handler);
  
  
  ///BLUETOOTH
  connection_service_subscribe((ConnectionHandlers) {.pebble_app_connection_handler = bluetooth_callback});
  
  
}

static void deinit() {
  window_destroy(s_main_window);
}

int main(void) {
  init();
  app_event_loop();
  deinit();
}
