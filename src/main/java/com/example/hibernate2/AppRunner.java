package com.example.hibernate2;

import com.example.hibernate2.model.Customer;
import com.example.hibernate2.model.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Component
public class AppRunner implements CommandLineRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) {

        //вспоминаю лямбды
        UserCreatable userCreation = () -> {
            ArrayList<String> names = new ArrayList(Arrays.asList("Maxim", "John", "Samuil", "Gabriel", "Ilona", "Mikhail", "Sasha", "Peter", "Lu", "Vsevolod", "Igor", "Ludwig", "Barry", "Harry", "Abraham", " Addison", " Adrian", " Albert", " Alec", " Alfred", " Alvin", " Andrew", " Andy", " Archibald", " Archie", " Arlo", " Arthur", " Arthur", " Austen", " Barnabe", " Bartholomew", " Bertram", " Bramwell", " Byam", " Cardew", " Chad", " Chance", " Colin", " Coloman", " Curtis", " Cuthbert", " Daniel", " Darryl", " David", " Dickon", " Donald", " Dougie", " Douglas", " Earl", " Ebenezer", " Edgar", " Edmund", " Edward", " Edwin", " Elliot", " Emil", " Floyd", " Franklin", " Frederick", " Gabriel", " Galton", " Gareth", " George", " Gerard", " Gilbert", " Gorden", " Gordon", " Graham", " Grant", " Henry", " Hervey", " Hudson", " Hugh", " Ian", " Jack", " Jaime", " James", " Jason", " Jeffrey", " Joey", " John", " Jolyon", " Jonas", " Joseph", " Joshua", " Julian", " Justin", " Kurt", " Lanny", " Larry", " Laurence", " Lawton", " Lester", " Malcolm", " Marcus", " Mark", " Marshall", " Martin", " Marvin", " Matt", " Maximilian", " Michael", " Miles", " Murray", " Myron", " Nate", " Nathan", " Neil", " Nicholas", " Nicolas", " Norman", " Oliver", " Oscar", " Osric", " Owen", " Patrick", " Paul", " Peleg", " Philip", " Phillipps", " Raymond", " Reginald", " Rhys", " Richard", " Robert", " Roderick", " Rodger", " Roger", " Ronald", " Rowland", " Rufus", " Russell", " Sebastian", " Shahaf", " Simon", " Stephen", " Swaine", " Thomas", " Tobias", " Travis", " Victor", " Vincent", " Vincent", " Vivian", " Wayne", " Wilfred", " William", " Winston", " Zadoc"));
            ArrayList<String> surnames = new ArrayList(Arrays.asList("Ivanov", "Petrov", "Sidorov", "Fiodorov", "Volonteev", "Serebrov", "Zemetz", "Herek", "Smitt", "Mobstick", "Witterson", "Jackson", "Simple", "Abramson", "Adamson", "Adderiy", "Addington", "Adrian", "Albertson", "Aldridge", "Allford", "Alsopp", "Anderson", "Andrews", "Archibald", "Arnold", "Arthurs", "Atcheson", "Attwood", "Audley", "Austin", "Ayrton", "Babcock", "Backer", "Baldwin", "Bargeman", "Barnes", "Barrington", "Bawerman", "Becker", "Benson", "Berrington", "Birch", "Bishop", "Black", "Blare", "Blomfield", "Boolman", "Bootman", "Bosworth", "Bradberry", "Bradshaw", "Brickman", "Brooks", "Brown", "Bush", "Calhoun", "Campbell", "Carey", "Carrington", "Carroll", "Carter", "Chandter", "Chapman", "Charlson", "Chesterton", "Clapton", "Clifford", "Coleman", "Conors", "Cook", "Cramer", "Creighton", "Croftoon", "Crossman", "Daniels", "Davidson", "Day", "Dean", "Derrick", "Dickinson", "Dodson", "Donaldson", "Donovan", "Douglas", "Dowman", "Dutton", "Duncan", "Dunce", "Durham", "Dyson", "Eddington", "Edwards", "Ellington", "Elmers", "Enderson", "Erickson", "Evans", "Faber", "Fane", "Farmer", "Farrell", "Ferguson", "Finch", "Fisher", "Fitzgerald", "Flannagan", "Flatcher", "Fleming", "Ford", "Forman", "Forster", "Foster", "Francis", "Fraser", "Freeman", "Fulton", "Galbraith", "Gardner", "Garrison", "Gate", "Gerald", "Gibbs", "Gilbert", "Gill", "Gilmore", "Gilson", "Gimson", "Goldman", "Goodman", "Gustman", "Haig", "Hailey", "Hamphrey", "Hancock", "Hardman", "Harrison", "Hawkins", "Higgins", "Hodges", "Hoggarth", "Holiday", "Holmes", "Howard", "Jacobson", "James", "Jeff", "Jenkin", "Jerome", "Johnson", "Jones", "Keat", "Kelly", "Kendal", "Kennedy", "Kennett", "Kingsman", "Kirk", "Laird", "Lamberts", "Larkins", "Lawman", "Leapman", "Leman", "Lewin", "Little", "Livingston", "Longman", "MacAdam", "MacAlister", "MacDonald", "Macduff", "Macey", "Mackenzie", "Mansfield", "Marlow", "Marshman", "Mason", "Mathews", "Mercer", "Michaelson", "Miers", "Miller", "Miln", "Milton", "Molligan", "Morrison", "Murphy", "Nash", "Nathan", "Neal", "Nelson", "Nevill", "Nicholson", "Nyman", "Oakman", "Ogden", "Oldman", "Oldridge", "Oliver", "Osborne", "Oswald", "Otis", "Owen", "Page", "Palmer", "Parkinson", "Parson", "Pass", "Paterson", "Peacock", "Pearcy", "Peterson", "Philips", "Porter", "Quincy", "Raleigh", "Ralphs", "Ramacey", "Reynolds", "Richards", "Roberts", "Roger", "Russel", "Ryder", "Salisburry", "Salomon", "Samuels", "Saunder", "Shackley", "Sheldon", "Sherlock", "Shorter", "Simon", "Simpson", "Smith", "Stanley", "Stephen", "Stevenson", "Sykes", "Taft", "Taylor", "Thomson", "Thorndike", "Thornton", "Timmons", "Tracey", "Turner", "Vance", "Vaughan", "Wainwright", "Walkman", "Wallace", "Waller", "Walter", "Ward", "Warren", "Watson", "Wayne", "Webster", "Wesley", "White", "WifKinson", "Winter", "Wood", "Youmans", "Young"));

            var random = new Random();
            return Customer.builder()
                    .name(names.get(random.nextInt(names.size())))
                    .surname(surnames.get(random.nextInt(surnames.size())))
                    .age((byte) random.nextInt(127))
                    .phone_number(String.valueOf(random.nextInt(100_000_000)))
                    .build();
        };

        OrderCreatable orderCreation = () -> {
            ArrayList<String> games = new ArrayList<>(Arrays.asList(".hack (серия игр)", ".kkrieger", "0 A.D.", "0x10c", "0xUniverse", "1-2-Switch", "1K ZX Chess", "2 Days to Vegas", "2Dark", "3 Ninjas Kick Back (игра)", "3 Skulls of the Toltecs", "The 3-D Battles of WorldRunner", "3-Demon", "3D Baseball", "3D Crazy Coaster", "3D Deathchase", "3D Lemmings", "3D Monster Maze", "The 3rd Birthday", "3rd Space Vest", "4x4 EVO 2", "4x4 Evolution", "7 Days to Die", "007 Legends", "7 Sins", "007: Quantum of Solace", "7.62 (игра)", "7.62: Перезарядка", "9 рота (игра)", "9 Monkeys of Shaolin", "10-Yard Fight", "11eyes", "12 is Better Than 6", "18 Wheels of Steel: Across America", "18 Wheels of Steel: American Long Haul", "18 Wheels of Steel: Extreme Trucker", "18 Wheels of Steel: Haulin’", "18 Wheels of Steel: Pedal to the Metal", "25 To Life", "60 Seconds!", "70’s Robot Anime Geppy-X", "102 Dalmatians: Puppies to the Rescue", "187 Ride or Die", "300: March to Glory", "720°", "1080° Snowboarding", "1942 (игра)", "1942: The Pacific Air War", "1943: The Battle of Midway", "2010 FIFA World Cup South Africa", "2014 FIFA World Cup Brazil", "2048 (игра)", "2400 A.D.", "3030 Deathwar", "Агрессия (игра)", "Акинатор", "Алёша Попович и Тугарин Змей (игра)", "Аллоды", "Аллоды Онлайн", "Аллоды II: Повелитель душ", "Аллоды: Печать тайны", "Альфа: Антитеррор", "Альфа: Антитеррор. Мужская работа", "Анабиоз: Сон разума", "Антанта (игра)", "Арена Онлайн", "Аэропорт-Сити", "Бейблэйд Бёрст", "Берсерк Онлайн", "Берсерк: Возрождение", "Берсерк: Катаклизм", "Бесконечное лето", "Беспокойные сердца", "Бизнес Мания", "Блицкриг (игра)", "Блицкриг 3", "Блицкриг II", "Блицкриг II: Возмездие", "Блицкриг II: Освобождение", "Блицкриг: Пылающий горизонт", "Бойцовский клуб (игра)", "Брат 2: Обратно в Америку", "Братва и кольцо", "Братья Пилоты: Загадка атлантической сельди", "Братья Пилоты: По следам полосатого слона", "Братья Пилоты. Олимпиада", "Бригада Е5: Новый альянс", "Бумер 2 (игра)", "Бумер: Сорванные башни", "Буря в стакане: Гонки на маршрутках", "В тылу врага (игра)", "В тылу врага 2", "В тылу врага 2: Братья по оружию", "В тылу врага 2: Лис пустыни", "В тылу врага 2: Штурм", "В тылу врага: Диверсанты", "В тылу врага: Штурм 2", "Валькирия: Восхождение на трон", "Вангеры", "Вверх (игра)", "Ведьмак (игра)", "Ведьмак 2: Убийцы королей", "Ведьмак 3: Дикая Охота", "Ведьмак 3: Дикая Охота — Каменные сердца", "Ведьмак 3: Дикая Охота — Кровь и вино", "Ведьмак: Кровавый след", "Весёлая ферма", "Вивисектор: зверь внутри", "Виртономика", "Владыки Астрала", "Властелин Колец Онлайн", "Власть закона (игра)", "Возвращение Атлантиды", "Война в небе — 1917", "Война племён", "Войны древности: Судьба Эллады", "Войны Империй", "Войны хаоса и порядка Онлайн", "Волкодав: Путь воина", "Волчица и пряности", "Ворона, или Как Иван-дурак за кладом ходил", "Восточный фронт: Крах Анненербе", "Восхождение на трон (игра)", "Врата;Штейна", "Врата;Штейна 0", "Времена Раздора", "Вторая мировая (игра)", "Вторая мировая: Нормандия", "Гвинт", "Генерал (игра)", "Герои войны и денег", "Герои неба: Вторая Мировая", "Герои уничтоженных империй", "Глаз дракона", "Гномы (игра)", "Говорящая Анджела", "Годвилль", "Гостевой клуб лицея Оран", "Громада (компьютерная игра)", "Губка Боб Квадратные Штаны: Битва за Лагуну Бикини", "Гуррен-Лаганн", "ГЭГ: Отвязное приключение", "Дальнобойщики 2 (игра)", "Дальнобойщики 3: Покорение Америки", "Дальнобойщики: Путь к победе", "Дальнобойщики: Транспортная компания", "Дарвин (компьютерная игра)", "Две сорванные башни (игра)", "Демиурги", "Демиурги II", "Диверсант (игра)", "Дневной Дозор (игра)", "Добрыня Никитич и Змей Горыныч (игра)", "Дорога на Хон-Ка-Ду", "Драгоценные зверюшки", "Драконы вечности", "Дух Дракона", "Дюрарара!!", "Жаркое лето", "Жесть (игра)", "Завоевание Америки", "Завтра война (игра)", "Заповедник Зелирия", "Запределье (игра)", "Зачарованная Катя", "Звёздное наследие", "Звёздные волки", "Звёздные волки 2: Гражданская война", "Звёздный Воитель", "Златогорье 2", "Златогорье 2: Холодные небеса", "Золотая бутса (игра)", "Золотая Орда (игра)", "Икариам", "Ил-2 Штурмовик (игра)", "Ил-2 Штурмовик: Битва за Британию", "Ил-2 Штурмовик: Забытые сражения", "Ил-2 Штурмовик: Крылатые хищники", "Илья Муромец и Соловей-Разбойник (игра)", "Именем Короля", "Империя Онлайн", "Империя: Смутное время", "Искусство войны. Корея", "Искусство войны. Курская дуга", "Кабанери железной крепости", "Казаки 3", "Казаки II: Наполеоновские войны", "Казаки: Европейские войны", "Казаки: Последний довод королей", "Казаки: Снова война", "Как достать соседа", "Как достать соседа 2: Адские каникулы", "Калибр (игра)", "Карибский кризис (игра)", "Карлик Нос (игра)", "Каталоги The Sims 2", "Кибергород Эдо", "Клавогонки"));
            var random = new Random();
            Date d1 = new Date(1212121212121L);
            Date d2 = new Date();

            Date randomDate = new Date(ThreadLocalRandom.current().nextLong(d1.getTime(), d2.getTime()));

            return Order.builder()
                    .date(randomDate)
                    .product_name(games.get(random.nextInt(games.size())))
                    .amount(random.nextInt(10_000))
                    .customer(userCreation.create())
                    .build();
        };

        var limit = 100;
        IntStream.range(0, limit).forEach(i -> entityManager.persist(userCreation.create()));
        IntStream.range(0, limit).forEach(i -> entityManager.persist(orderCreation.create()));
    }
}

interface UserCreatable {
    Customer create();
}
 interface OrderCreatable {
    Order create();
 }


