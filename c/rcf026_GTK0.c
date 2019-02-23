#include <gtk/gtk.h>
#include <stdio.h>

/*
 *  Successfully creates a GTK window.
 *
 *  Compile with:
 *   cc `pkg-config --cflags gtk+-3.0` rcf026_GTK0.c `pkg-config --libs gtk+-3.0`
 * 
 *  Resource:
 *   https://developer.gnome.org/gtk3/stable/gtk-getting-started.html
 */

static void activate( GtkApplication * app, gpointer user_data)
{
    GtkWidget * window; // The window widget is the primary application container.

    window = gtk_application_window_new( app );
    gtk_window_set_title( GTK_WINDOW(window), "RCF026_GTK0");
    gtk_window_set_default_size( GTK_WINDOW(window), 300, 200);
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
