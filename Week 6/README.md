# Praktikum PBO Pertemuan 6 - Polymorphism

## Struktur

- source/case1-employee/: Firm, Staff, StaffMember, Volunteer, Employee, Executive, Hourly, Commission.
- source/case2-painting-shapes/: Shape, Sphere, Rectangle, Cylinder, Paint, PaintThings.
- source/case3-polymorphic-sorting/: Sorting, Numbers, Strings, Salesperson, WeeklySales.
- experiments/: source yang (sengaja gagal compile), dipisahkan dari source final.
- build/: hasil kompilasi; dapat dibuat ulang dengan perintah berikut.

## Compile dan run

Jalankan dari folder `Week 6`. Compile setiap kasus secara terpisah.

powershell

javac -Xlint:all -d build/case1-employee source/case1-employee/*.java
java -cp build/case1-employee Firm baseline
java -cp build/case1-employee Firm
java -cp build/case1-employee Firm twice

javac -Xlint:all -d build/case2-painting-shapes source/case2-painting-shapes/*.java
java -cp build/case2-painting-shapes PaintThings

javac -Xlint:all -d build/case3-polymorphic-sorting source/case3-polymorphic-sorting/*.java
java -cp build/case3-polymorphic-sorting Numbers selection
java -cp build/case3-polymorphic-sorting Numbers
java -cp build/case3-polymorphic-sorting Strings selection
java -cp build/case3-polymorphic-sorting Strings
java -cp build/case3-polymorphic-sorting WeeklySales


Numbers: ketik `6 7 -2 9 7 0 3` lalu Enter.
Strings: ketik `5 apel jeruk mangga apel pisang` lalu Enter.
Tanpa argumen, keduanya memakai insertionSort descending. Argumen `selection` memakai selectionSort ascending.

## Reproduksi error yang diharapkan

powershell

javac -cp build/case3-polymorphic-sorting -d build experiments/int-array/NumbersPrimitive.java
javac -cp build/case2-painting-shapes -d build experiments/abstract-shape/AbstractShapeProbe.java

