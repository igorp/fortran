//Nopeus
ax = 0;

for (var i=0;i<1.5;i=i+0.1) {
    ax = ax + (1 + 2*Math.sin(2*i)) * 0.1;
}

alert("Nopeus: " + (-1 + ax));

//Matka
vx = 0;

for (var i=0;i<1.5;i=i+0.1) {
    vx = vx + (i-Math.cos(2*i)) * 0.1;
}

alert("Matka: " + (2 + vx));
