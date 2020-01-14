# Make a number of seconds human-readable.

def make_readable(seconds):
    s = seconds % 60
    m = int((seconds - s) / 60) % 60
    h = int(((seconds - m - s) / 60) / 60)
    return("{}:{}:{}".format(pad(h), pad(m), pad(s)))


def pad(x):
    x = str(x)
    if len(x) < 2:
        x = "0" + x

    return x
