package ca.barnhart.harngm.data;

import ca.barnhart.harngm.entities.data.*;
import ca.barnhart.harngm.repositories.*;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;
import static com.google.common.collect.Sets.newHashSet;

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

        this.armourComponentRepository.save(new ArmourComponent(
                "cap",
                "Hat/Cap",
                "Covers the top of the head.",
                head,
                newHashSet(sk),
                newHashSet(leather)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "cowl/sh",
                "Cowl/Coif (Short)",
                "A cowl is a large loose hood. A coif is a close fitting cap.",
                head,
                newHashSet(sk, nk),
                newHashSet(cloth, leather, quilt, ring, scale, mail)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "cowl/lg",
                "Cowl/Coif (Long)",
                "A cowl is a large loose hood. A coif is a close fitting cap.",
                head,
                newHashSet(sk, nk, sh),
                newHashSet(cloth, leather, quilt, ring, scale, mail)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "halfhelm",
                "Halfhelm",
                "A helmet protecting the skull.",
                head,
                newHashSet(sk),
                newHashSet(kurbul, ring, plate, mail)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "greathelm",
                "Great Helm",
                "A helmet protecting the skull, face, and neck.",
                head,
                newHashSet(sk, fa, nk),
                newHashSet(plate)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "gorget",
                "Gorget",
                "Protects neck.",
                head,
                newHashSet(nk),
                newHashSet(plate)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "vest",
                "Vest",
                "A sleeveless shirt to the waist.",
                torso,
                newHashSet(sh, tx_ch, tx_bk, ab_ch, ab_bk),
                newHashSet(cloth)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "shirt/sh",
                "Shirt (Short)",
                "A short sleeve shirt to the waist.",
                torso,
                newHashSet(sh, ua, tx_ch, tx_bk, ab_ch, ab_bk),
                newHashSet(quilt)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "shirt/lg",
                "Shirt (Long)",
                "A short sleeve shirt to below the groin.",
                torso,
                newHashSet(sh, ua, tx_ch, tx_bk, ab_ch, ab_bk, hp, gr),
                newHashSet(cloth, ring)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "shirt/sleeve",
                "Shirt w/Sleeve",
                "A long sleeve shirt to below the groin.",
                torso,
                newHashSet(sh, ua, el, fo, tx_ch, tx_bk, ab_ch, ab_bk, hp, gr),
                newHashSet(cloth)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "tunic",
                "Tunic",
                "A short sleeve shirt to above the knees.",
                torso,
                newHashSet(sh, ua, tx_ch, tx_bk, ab_ch, ab_bk, hp, gr, th),
                newHashSet(cloth, leather, quilt)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "smock",
                "Smock",
                "A long sleeve shirt to above the knees.",
                torso,
                newHashSet(sh, ua, el, fo, tx_ch, tx_bk, ab_ch, ab_bk, hp, gr, th),
                newHashSet(cloth, quilt)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "surcoat",
                "Surcoat",
                "A sleeveless shirt to below the knees.",
                torso,
                newHashSet(sh, tx_ch, tx_bk, ab_ch, ab_bk, hp, gr, th, kn),
                newHashSet(cloth, quilt)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "robe",
                "Robe",
                "A long sleeve shirt to above the feet.",
                torso,
                newHashSet(sh, ua, el, fo, tx_ch, tx_bk, ab_ch, ab_bk, hp, gr, th, kn, cf),
                newHashSet(cloth)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "gambeson",
                "Gambeson",
                "A padded short sleeve jacket to above the knees.",
                torso,
                newHashSet(sh, ua, tx_ch, tx_bk, ab_ch, ab_bk, hp, gr, th),
                newHashSet(quilt)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "habergeon",
                "Habergeon",
                "A sleeveless coat of mail to below the groin.",
                torso,
                newHashSet(sh, ua, tx_ch, tx_bk, ab_ch, ab_bk, hp, gr),
                newHashSet(scale, mail)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "hauberk/sh",
                "Hauberk (Short)",
                "A short sleeve coat of mail to above the knees",
                torso,
                newHashSet(sh, ua, tx_ch, tx_bk, ab_ch, ab_bk, hp, gr, th),
                newHashSet(ring, scale, mail)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "hauberk/lg",
                "Hauberk (Long)",
                "A short sleeve coat of mail to below at the knees",
                torso,
                newHashSet(sh, ua, tx_ch, tx_bk, ab_ch, ab_bk, hp, gr, th, kn),
                newHashSet(ring, scale, mail)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "breastplate",
                "Breastplate",
                "Plate covering the chest.",
                torso,
                newHashSet(tx_ch, ab_ch),
                newHashSet(kurbul, plate)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "cuirass",
                "Cuirass",
                "Plate covering the torso.",
                torso,
                newHashSet(tx_ch, tx_bk, ab_ch, ab_bk),
                newHashSet(kurbul, plate)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "ailettes",
                "Ailettes",
                "Flat shoulder cover.",
                arms,
                newHashSet(sh),
                newHashSet(kurbul, plate)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "rerebraces",
                "Rerebraces",
                "Protects upper arms.",
                arms,
                newHashSet(ua),
                newHashSet(kurbul, plate)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "coudes",
                "Coudes",
                "Protects elbow.",
                arms,
                newHashSet(el),
                newHashSet(kurbul, plate)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "vambraces",
                "Vambraces",
                "Protects forearms.",
                arms,
                newHashSet(fo),
                newHashSet(leather, kurbul, plate)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "gauntlets",
                "Gauntlets",
                "Gloves.",
                arms,
                newHashSet(ha),
                newHashSet(leather, ring, mail)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "mittens",
                "Mittens",
                "Mittens.",
                arms,
                newHashSet(ha),
                newHashSet(mail)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "breeches",
                "Breeches",
                "Pants from waist to the knees.",
                legs,
                newHashSet(hp, gr, th, kn),
                newHashSet(cloth, leather)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "hose",
                "Hose/Trousers",
                "Pants from waist to ankles.",
                legs,
                newHashSet(hp, gr, th, kn, cf),
                newHashSet(cloth, leather, quilt)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "leggings",
                "Leggings",
                "Covers upper legs and feet.",
                legs,
                newHashSet(th, kn, cf, ft),
                newHashSet(cloth, leather, quilt, ring, scale, mail)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "kneecops",
                "Kneecops",
                "Protects knees.",
                legs,
                newHashSet(kn),
                newHashSet(kurbul, plate)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "calvesswaddle",
                "Calves Swaddle",
                "Protects calves.",
                legs,
                newHashSet(cf),
                newHashSet(cloth)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "greaves",
                "Greaves",
                "Protects calves.",
                legs,
                newHashSet(cf),
                newHashSet(kurbul, plate)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "kneeboots",
                "Knee Boots",
                "Protects knees, calves, and feet.",
                legs,
                newHashSet(kn, cf, ft),
                newHashSet(leather)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "footswaddle",
                "Foot Swaddle",
                "Protects calves and feet.",
                legs,
                newHashSet(cf, ft),
                newHashSet(cloth)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "calfboots",
                "Calf Boots",
                "Protects calves and feet.",
                legs,
                newHashSet(cf, ft),
                newHashSet(leather)
        ));
        this.armourComponentRepository.save(new ArmourComponent(
                "shoes",
                "Shoes",
                "Protects feet.",
                legs,
                newHashSet(ft),
                newHashSet(leather)
        ));
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
