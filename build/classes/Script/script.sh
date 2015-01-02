cd ~/achooPhotos
PID=$(pgrep gnome-session)
export DBUS_SESSION_BUS_ADDRESS=$(grep -z DBUS_SESSION_BUS_ADDRESS /proc/$PID/environ|cut -d= -f2-)
for file in *.*
do
    name=${file}
    mpath=`pwd`
    rr="file://"$mpath"/"$name
    gsettings set org.gnome.desktop.background picture-uri "$rr"
    sleep 10
done