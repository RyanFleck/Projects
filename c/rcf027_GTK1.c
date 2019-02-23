#include <gtk/gtk.h>

/*
 *  Additionally adds a button and text.
 *
 *  Compile with:
 *   cc `pkg-config --cflags gtk+-3.0` rcf026_GTK0.c `pkg-config --libs gtk+-3.0`
 * 
 *  Resource:
 *   https://developer.gnome.org/gtk3/stable/gtk-getting-started.html
 */

// Button actions.

static void print_hello ( GtkWidget *widget, gpointer data )
{
    g_print("Hello World\n");
}



// Main GTK window setup.

static void activate( GtkApplication * app, gpointer user_data)
{
    GtkWidget * window;
    GtkWidget * button;
    GtkWidget * button_box;

    // Setup Window
    window = gtk_application_window_new( app );
    gtk_window_set_title( GTK_WINDOW(window), "RCF026_GTK0");
    gtk_window_set_default_size( GTK_WINDOW(window), 300, 200);
    
    // Setup Button_Box
    button_box = gtk_button_box_new( GTK_ORIENTATION_HORIZONTAL );
    gtk_container_add( GTK_CONTAINER( window ), button_box );

    // Setup Button
    button = gtk_button_new_with_label( "Hello World" );
    g_signal_connect( button, "clicked", G_CALLBACK( print_hello ), NULL );
    // g_signal_connect_swapped( button, "clicked", G_CALLBACK( gtk_widget_destroy ), window  );
    gtk_container_add( GTK_CONTAINER( button_box ), button );

    // Render.
    gtk_widget_show_all( window );
}

int main ( int argc, char **argv )
{    
    GtkApplication *app;
    int status;

    app = gtk_application_new ( "org.rcf.test_zero", G_APPLICATION_FLAGS_NONE);
    g_signal_connect (app, "activate", G_CALLBACK (activate), NULL);
    status = g_application_run (G_APPLICATION (app), argc, argv);
    g_object_unref (app);

    return status;
}
