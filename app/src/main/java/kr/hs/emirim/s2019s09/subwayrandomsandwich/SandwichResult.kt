package kr.hs.emirim.s2019s09.subwayrandomsandwich

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.util.Random

class SandwichResult : AppCompatActivity() {
    lateinit var img : ImageView
    lateinit var info : TextView
    lateinit var menu : TextView
    lateinit var bread : TextView
    lateinit var cheese : TextView
    lateinit var sauce : TextView

    var menuArray = arrayOf<Menu>(
        Menu("로스트 치킨", "오븐에 구워 담백한 저칼로리 닭가슴살의 건강한 풍미", 233, 320, 8, 23, 2, 610, "roasted_chicken"),
        Menu("에그마요", "부드러운 달걀과 고소한 마요네즈가 만나 더 부드러운 스테디셀러", 247, 480, 7, 17, 5, 450, "egg_mayo"),
        Menu("K-바비큐", "써브웨이 최초의 코르안 스타일 샌드위치! 마늘, 간장 그리고 은은한 불맛까지!", 254, 378, 12, 24, 2, 907, "k_bbq"),
        Menu("쉬림프", "탱글한 식감의 통새우가 들어가 한입 베어 먹을 때마다 진짜 새우의 풍미가 가득", 187, 253, 5, 12, 1, 355, "shrimp"),
        Menu("로티세리 바비큐 치킨", "촉촉한 바비큐 치킨의 풍미가득. 손으로 찢어 더욱 부드러운 치킨의 혁명", 247, 350, 7, 29, 2, 660, "rotisserie_barbecue_chicken"),
        Menu("풀드 포크 바비큐", "훈연한 미국 스타일의 풀드 포크 바비큐가 가득 들어간 샌드위치", 276, 420, 24, 23, 2, 980, "pulled_pork"),
        Menu("이탈리안 비엠티", "페퍼로니, 살라미, 그리고 햄이 만들어내는 최상의 조화!", 226, 410, 8, 20, 6, 1260, "italian_bmt"),
        Menu("비엘티", "오리지널 아메리칸 스타일 베이컨의 풍미와 바삭함 그대로", 165, 380, 7, 20, 5, 1130, "blt"),
        Menu("미트볼", "이탈리안 스타일 비프 미트볼에 써브웨이만의 풍부한 토마토 향이 살아있는 마리나라소스를 듬뿍", 301, 480, 12, 21, 7, 1000, "meatball"),
        Menu("햄", "기본 중에 기본! 풍부한 햄이 만들어내는 입 안 가득 넘치는 맛의 향연", 219, 290, 8, 18, 1, 800, "ham"),
        Menu("참치", "남녀노소 누구나 좋아하는 담백한 참치와 고소한 마요네즈의 완벽한 조화", 237, 480, 7, 20, 5, 580, "tuna"),
        Menu("써브웨이 클럽", "명실공히 시그니처 써브! 터키, 비프, 포크 햄의 완벽한 앙상블", 240, 310, 8, 23, 2, 840, "subway_club"),
        Menu("터키", "280kcal로 슬림하게 즐기는 오리지날 터키 샌드위치", 219, 280, 7, 18, 1, 760, "turkey"),
        Menu("베지", "갓 구운 빵과 신선한 7가지 야채로 즐기는 깔끔한 한끼", 162, 230, 7, 8, 1, 280, "veggie_delite"),
        Menu("스테이크 & 치즈", "육즙이 쫙~ 풍부한 비프 스테이크의 풍미가 입안 한가득", 245, 380, 9, 26, 5, 1030, "steak_cheese"),
        Menu("터키 베이컨 아보카도", "담백한 터키와 바삭한 베이컨 환상조합에 부드러운 아보카도는 신의 한수", 270, 420, 8, 24, 4, 1190, "turkey_bacon_avocado"),
        Menu("써브웨이 멜트", "자신있게 추천하는 터키, 햄, 베이컨의 완벽한 맛의 밸런스", 235, 365, 10, 23, 4, 1200, "subway_melt"),
        Menu("스파이시 이탈리안", "살라미, 페퍼로니가 입안 한가득! 쏘 핫한 이탈리아의 맛", 222, 480, 8, 20, 9, 1490, "spicy_italian"),
        Menu("치킨 데리야끼", "담백한 치킨 스트립에 달콤짭쪼름한 써브웨이 특제 데리야끼 소스와의 환상적인 만남", 269, 370, 16, 25, 1, 770, "chicken_teriyaki")
    )
    var breadArray = arrayOf<String>("허니오트", "하티", "위트", "파마산 오레가노", "화이트", "플랫브레드")
    var cheeseArray = arrayOf<String>("아메리칸 치즈", "슈레드 치즈", "모차렐라 치즈")
    var sauceArray = arrayOf<String>("랜치", "마요네즈", "스위트 어니언", "허니 머스타드", "스위트 칠리", "핫 칠리", "사우스웨스트 치폴레", "머스타드", "홀스래디쉬", "올리브 오일", "레드와인식초", "스모크 바비큐")

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sandwich_result)

        val random = Random()
        val menu_num = random.nextInt(menuArray.size)
        val bread_num = random.nextInt(breadArray.size)
        val cheese_num = random.nextInt(cheeseArray.size)
        val sauce_num1 = random.nextInt(sauceArray.size)
        var sauce_num2 = random.nextInt(sauceArray.size)
        while (sauce_num1 == sauce_num2) {
            sauce_num2 = random.nextInt(sauceArray.size)
        }

        img = findViewById(R.id.sandwichImg)
        info = findViewById(R.id.infotext)
        menu = findViewById(R.id.menutext)
        bread = findViewById(R.id.breadtext)
        cheese = findViewById(R.id.cheesetext)
        sauce = findViewById(R.id.saucetext)

        img.setImageResource(resources.getIdentifier("@drawable/" + menuArray.get(menu_num).img, "drawable", packageName))
        menu.text = menuArray.get(menu_num).name
        info.text = menuArray.get(menu_num).info
        bread.text = "빵 : " + breadArray.get(bread_num)
        cheese.text = "치즈 : " + cheeseArray.get(cheese_num)
        sauce.text = "소스 : " + sauceArray.get(sauce_num1) + ", " + sauceArray.get(sauce_num2)

        findViewById<Button>(R.id.home).setOnClickListener {
            val intent : Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.nutrient_btn).setOnClickListener {
            var dlg = AlertDialog.Builder(this)
                .setTitle("영양성분표")
                .setMessage("중량(g) : " + menuArray.get(menu_num).weigth
                        + "\n열량(kacl) : " + menuArray.get(menu_num).calorie
                        + "\n당류(g) : " + menuArray.get(menu_num).sugars
                        + "\n단백질(g) : " + menuArray.get(menu_num).protein
                        + "\n포화지방(g) : " + menuArray.get(menu_num).fat
                        + "\n나트륨(mg) : " + menuArray.get(menu_num).salt)
                .show()
        }
    }
}