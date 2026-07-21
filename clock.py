import tkinter as tk
from time import strftime

def update_time():
    # Fetch current time string (Format: Hours:Minutes:Seconds AM/PM)
    string_time = strftime('%I:%M:%S %p')
    # Update the label text
    watch_label.config(text=string_time)
    # Schedule the function to run again after 1000ms (1 second)
    watch_label.after(1000, update_time)

# Initialize the main window
root = tk.Tk()
root.title("Digital Watch")

# Style the watch display
watch_label = tk.Label(
    root, 
    font=('calibri', 50, 'bold'), 
    background='black', 
    foreground='cyan'
)

# Place the watch in the window center
watch_label.pack(anchor='center')

# Fire the initial time function and start the loop
update_time()
root.mainloop()
