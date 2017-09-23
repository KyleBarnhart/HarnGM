package ca.barnhart.harngm.data;

import ca.barnhart.harngm.entities.*;
import ca.barnhart.harngm.entities.Character;
import ca.barnhart.harngm.repositories.*;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final ArmourQualityRepository armourQualityRepository;
    private final ArmourComponentRepository armourComponentRepository;
    private final AspectRepository aspectRepository;
    private final BodyPartRepository bodyPartRepository;
    private final BodyPartCategoryRepository bodyPartCategoryRepository;
    private final MaterialRepository materialRepository;

    private Aspect b = new Aspect("b", "Blunt");
    private Aspect e = new Aspect("e", "Edge");
    private Aspect p = new Aspect("p", "Point");
    private Aspect f = new Aspect("f", "Fire/Frost");
    private Aspect s = new Aspect("s", "Squeeze");
    private Aspect t = new Aspect("t", "Tear");

    @Autowired
    public DatabaseLoader(
            ArmourQualityRepository armourQualityRepository,
            ArmourComponentRepository armourComponentRepository,
            AspectRepository aspectRepository,
            BodyPartRepository bodyPartRepository,
            BodyPartCategoryRepository bodyPartCategoryRepository,
            MaterialRepository materialRepository
    ) {
        this.armourQualityRepository = armourQualityRepository;
        this.armourComponentRepository = armourComponentRepository;
        this.aspectRepository = aspectRepository;
        this.bodyPartRepository = bodyPartRepository;
        this.bodyPartCategoryRepository = bodyPartCategoryRepository;
        this.materialRepository = materialRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.aspectRepository.save(b);
        this.aspectRepository.save(e);
        this.aspectRepository.save(p);
        this.aspectRepository.save(f);
        this.aspectRepository.save(s);
        this.aspectRepository.save(t);

        BodyPartCategory head = new BodyPartCategory("head", "Head");
        BodyPartCategory arms = new BodyPartCategory("arms", "Arms");
        BodyPartCategory torso = new BodyPartCategory("torso", "Torse");
        BodyPartCategory legs = new BodyPartCategory("legs", "Legs");

        this.bodyPartCategoryRepository.save(head);
        this.bodyPartCategoryRepository.save(arms);
        this.bodyPartCategoryRepository.save(torso);
        this.bodyPartCategoryRepository.save(legs);

        BodyPart sk = new BodyPart("sk", "Skull", head, 4);
        BodyPart fa = new BodyPart("fa", "Face", head, 3);
        BodyPart nk = new BodyPart("nk", "Neck", head, 2);
        BodyPart sh = new BodyPart("sh", "Shoulder", arms, 3);
        BodyPart ua = new BodyPart("ua", "Upper Arm", arms, 6);
        BodyPart el = new BodyPart("el", "Elbow", arms, 2);
        BodyPart fo = new BodyPart("fo", "Forearm", arms, 5);
        BodyPart ha = new BodyPart("ha", "Hand/Wrist", arms, 5);
        BodyPart tx_ch = new BodyPart("tx_ch", "Thorax (Chest)", torso, 6);
        BodyPart tx_bk = new BodyPart("tx_bk", "Thorax (Back)", torso, 6);
        BodyPart ab_ch = new BodyPart("ab_ch", "Abdomen (Chest)", torso, 6);
        BodyPart ab_bk = new BodyPart("ab_bk", "Abdomen (Back)", torso, 6);
        BodyPart hp = new BodyPart("hp", "Hips", torso, 9);
        BodyPart gr = new BodyPart("gr", "Groin", torso, 1);
        BodyPart th = new BodyPart("th", "Thighs", legs, 14);
        BodyPart kn = new BodyPart("kn", "Knees", legs, 3);
        BodyPart cf = new BodyPart("cf", "Calves", legs, 12);
        BodyPart ft = new BodyPart("ft", "Feet", legs, 7);

        this.bodyPartRepository.save(sk);
        this.bodyPartRepository.save(fa);
        this.bodyPartRepository.save(nk);
        this.bodyPartRepository.save(sh);
        this.bodyPartRepository.save(ua);
        this.bodyPartRepository.save(el);
        this.bodyPartRepository.save(fo);
        this.bodyPartRepository.save(ha);
        this.bodyPartRepository.save(tx_ch);
        this.bodyPartRepository.save(tx_bk);
        this.bodyPartRepository.save(ab_ch);
        this.bodyPartRepository.save(ab_bk);
        this.bodyPartRepository.save(hp);
        this.bodyPartRepository.save(gr);
        this.bodyPartRepository.save(th);
        this.bodyPartRepository.save(kn);
        this.bodyPartRepository.save(cf);
        this.bodyPartRepository.save(ft);

        Material cloth = new Material("cloth", "Cloth", getProtectiveValues(0,1,0,1,0,1), 5, 100);
        Material leather = new Material("leather", "Leather", getProtectiveValues(1,2,1,3,0,2), 15, 200);
        Material quilt = new Material("quilt", "Quilt", getProtectiveValues(5,1,1,3,1,3), 20, 400);
        Material kurbul = new Material("kurbul", "Kûrbúl", getProtectiveValues(4,4,3,3,2,4), 18, 500);
        Material ring = new Material("ring", "Ring", getProtectiveValues(2,5,1,3,1,4), 40, 700);
        Material scale = new Material("scale", "Scale", getProtectiveValues(3,5,4,4,1,5), 60, 1000);
        Material mail = new Material("mail", "Mail", getProtectiveValues(2,7,6,4,0,8), 50, 1500);
        Material plate = new Material("plate", "Plate", getProtectiveValues(5,8,7,5,3,10), 60, 1500);

        this.materialRepository.save(cloth);
        this.materialRepository.save(leather);
        this.materialRepository.save(quilt);
        this.materialRepository.save(kurbul);
        this.materialRepository.save(ring);
        this.materialRepository.save(scale);
        this.materialRepository.save(mail);
        this.materialRepository.save(plate);

        this.armourQualityRepository.save(new ArmourQuality(7, 60, 120));
        this.armourQualityRepository.save(new ArmourQuality(8, 70, 115));
        this.armourQualityRepository.save(new ArmourQuality(9, 90, 105));
        this.armourQualityRepository.save(new ArmourQuality(10, 100, 100));
        this.armourQualityRepository.save(new ArmourQuality(11, 125, 113));
        this.armourQualityRepository.save(new ArmourQuality(12, 150, 125));
        this.armourQualityRepository.save(new ArmourQuality(13, 200, 150));
        this.armourQualityRepository.save(new ArmourQuality(14, 275, 188));
        this.armourQualityRepository.save(new ArmourQuality(15, 375, 288));
    }

    private Map<Aspect, Integer> getProtectiveValues(int bVal, int eVal, int pVal, int fVal, int tVal, int sVal) {
        Map<Aspect, Integer> values = new HashMap<>();

        values.put(b, bVal);
        values.put(e, eVal);
        values.put(p, pVal);
        values.put(f, fVal);
        values.put(t, tVal);
        values.put(s, sVal);

        return values;
    }
}
