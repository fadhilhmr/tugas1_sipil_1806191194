# Tutorial APAP
## Authors
* **FADHIL ILHAM RAHMADI** - *1806191194* - *A*

### What I have learned today TUTORIAL 4
### Personal Note
1. *Jelaskan perbedaan th:include dan th:replace!*
Perbedaannya adalah include akan menambahkan fragment ke div yang ditentukan, sedangkan replace akan mengganti tag div terpilih dengan isi fragment.
2. *Jelaskan apa fungsi dari th:object!*
fungsi th:object adalah untuk mengikat tag html dengan objek yang tersedia, sehingga di dalam tag tersebut bisa memanggil attributnya secara lansgung dengan asterisk "*{attr}" , dimana tanpa th:object bantuknya akan seperti ini = "${object.attr}"
3. *Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?*
 sebenarnya kegunaan dari * dan $ di th:object, sama sama untuk mngakses object. perbadaanya adalah $ digunakan ketika object belum diinisiasi sebelumnya katika diakses, sedangkan * menambahkan attribut dari object yang sudah diinisiasi oleh tag tertentu seperti th:object
4. *Bagaimana kamu menyelesaikan latihan nomor 3?*
Untuk latihan tiga, saya memanfaatkan fragment yang sudah ada dengan menambahkan argumen dengan input string, sehingga setiap dimasukkan string di argumen fragment tersebut, maka fragment akan mengupdate isi navbarnya dengan string yang didapatkan dari masing masing html.


### What I have learned today TUTORIAL 3
### Personal Note
1. *Pada class KamarDb, terdapat method findAllByHotelId, apakah kegunaan dari method tersebut?*
Method tersebut berguna untuk mengakses database dan mereturn semua isi database dengan hotel ID yang ditaruh di argumen.
2. *Pada class HotelController, jelaskan perbedaan method addHotelFormPage dan addHotelSubmit?*
perbedannya adalah bahwa addhotelformpage mengambil data yang sudah ada dan dimasukkan ke model untuk direturn ke file html, sedangkan addhotelsubmit aka mengembalikan updated model yang berisid ari input user ke html yang sama.
3. *Jelaskan kegunaan dari JPA Repository!*
JPA repository merupakan database yang memerakan java class kita ke relational table. JPA repository membuat convert dari jaca ke database menjadi lebih mudah
4. *Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara HotelModel dan KamarModel dibuat?*
ketika ada tambahan anotasi dimasing masing Model yaitu onetomany/manytoone, dimana membuat kedua database saling mereferensikan satu sama lain
5. *Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER*
fetchtype.lazy =  untuk membuat seluruh object , KETIKA dipanggil  
cascadetype.all = untuk mendukung perubahasn CRUD database
fetchtype.eager = dibuat untuk relasi one to one dan many to one lalu bisa digunakan langsung untuk memanggil object

### What I have learned today TUTORIAL 2
### Personal Note
1. *Pertanyaan 1*
Karena belum disediakan html file/template untuk ditampilkan ke pengguna di website.
2. *Pertanyyaan 2*
Menurut saya, Autowired bertugas untuk secarar otomatis membuat semua class/fungsinya mengimplement suatu package/class tertentu, sehingga ada gungsi atau class yang dibuat dapat diberikan depedensinya.

3. *Pertanyaan 3*
Hal ini karena inisiasi dari hoteModel yang sudah dibuat mengharuskan  adanya input nomor telepon yang bersifat sebagai string. Ketidakadaan data membuat null dan raise error untuk pembuatan data tersebut. Harus dibuat handler untuk kases itu.
4. *Pertanyaan 4*
untuk mencari sesuai nama, maka dibutuhkan handler baru yang dapt menginterasi ke isi list hotel dan mencocokkan string nama input dengan nama hotel yang sudah ada.
5. *Pertanyaan 5*
link ini akan menampilkan seluruh data hotel yang sudah dibuat. screenshot berada di link ini
https://docs.google.com/document/d/1uWwF0eOFpuvFy5MT5_DZJENgk9PAIR8QgpaXR_uLcVs/edit?usp=sharing


### What I have learned today TUTORIAL 1
### Personal Note
### Github
1. *Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?*
Menurut saya, issue tracker adalah suatu fitur untuk mengawasi atau memulai suatu pengerjaan solusi dari suatu branch atau feature yang sudah dibuat
2. *Apa perbedaan dari git merge dan git merge --squash?*
git merge akan menyimpan semua versionn dari commit yang ada di branch tersebut. Dengan --squash, maka hanya akan ada satu commit daja dari brannch tersebut yang akan dipush ke master.
3. *Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?*
kelebihan dari penggunaan GIT adalah kita bisa mengontrol apa yang kita kerjakan melalui log yang ada dan juga ada safety condition ketka kita ingin mengubah sesuatu bisa melalui branch untuk meminimalisir perubahan data master/utama. dengan adanya versionn control system, kita bisa mentrack semua perubahan yang pernah terjadi dengan code kita.
### Spring
4. *Apa itu library & dependency?*
**Library** adalah kumpulan objek/class yang sudah digabungkan  dan siap di impelementasikan. **depedency** adalah hal yang membuat objjek tersebut bergantung dengan kelas lain.
5. *Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?*
Setahu saya, maaven adalah seperti package yang memiliki format dan aturan sendiri, sehingga, ketika kit amengejakan sesuatu secara kolaborartif, ada acuan yang bisa digunakan bersama. Alternatif dari Maven adalah gradle.
6. *Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?*
pengembangan suatu sistem informasi, mobile app
7. *Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?*
@RequestParam mendapatkan value dari query ayng ada di app tersebut, sedangkan @PathVaariable mendapatkan nilai dari URI-nya. Kegunaan requestparam lebih ke web sederhana/trqadisional, sedangkkan pathvariable untuk web yang kompleks.
### What I did not understand
- [x] apa saja command line penting ketika menggunakan command prompt
- [x] cara mengerjakan tutorial 1
- [ ] LATIHAN 4 TUTORIAL 4
- [x] Adaptasi menggunakan Intelij
- [ ] Konsep abstract dan interface di java harus dikaji ulang
 - [ ] method dan object di JPA dan perdatabasean java

