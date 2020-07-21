package FindWordsThatCanBeFormedByCharacters;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: LeetCode
 * @date: 2020/7/21
 */
public class SolutionTest {

    @Test
    public void countCharacters() {
        String[] words = new String[]{"pxlqovnbsgvqjzpfeidchzrodnbqfrccfydzjptukscjuatlsrcurepllxzyghhdepitqptlmfkhzxjgswaulxkfydhkilg", "uqklvqnlhdkwryjawkqfajfpbcnhglxlwxlaskxlytr", "jvgkxcdkxrvfahjkvhmfuyjzxtyxrsogbtsjybeaxugqymcr", "rgxditmosplnqvodtis", "jm", "ruqjwejuanjtiizcmbieobesnjnadzqvqumggblzmkxilgfarnxwpcawtkzxlvugibpidvwtikloeziuxqoi", "wxeyzrnbhlhwxecrgejsrawyulynvgtszwqqlihkcvckgcgtgpyqtkuwvjywmhpskaiwmpyarftqhnogxpith", "vdpbykqlihtpvfnqbrcjpggojqbalerohyitktuikbffvfatcnneuvbanjihiaorrjcdthntnrxebfhvshmpodmzhtwnasbm", "wgjstkoaojcesfdrllugmojwdmgeejyiqvshlowtktddattunarnohgvqsoskfmbrami", "ecwqxbawirvnxvsjybbebclaturorlcbpf", "gtjbaigvufrotlwfoqqolnjabnvtbcygtfcytinzpcjbvprdkdjawrcbthmxjrabimhhs", "cvzlbrvppkyxtjxzeglzwoagmpjnfxddbwolxmwdohgtfktgftzzkwpianslkpldyfzubtjczse", "neaw", "mxhmvkajofnmdiiduactlemcvpztscmsnrdhuhquxnnzywsrzxyplgbppiypxwcfbsnyzblaeifo", "krekecabfpufucjhqphjnibaeqdvdpmrfougdwugvoioqangdnxromwlxnfeydaneyazzclscqgdxlhhgnoqmslfflzqv", "klutvchxsceihfmzitgqakytesfjykribjhjzdruuoycjkwaghmmqkfrhkrtawudtjyjwqbyspamlegqjlwlj", "raykfkflqdzrpthdejetwolgciygwaktulkxemkdbbllkjxhnnafsms", "os", "xhchkcetmlprcdmrnalvkvgabxxnomphqpqhnddqhecogspbdebeoshvjgzvmqu", "jqtdysnpskktynxwmsfaabglagnqcllptvuyyqjwrmqaftenusmsahhhqubkwxltpr", "sulmwluiwvlroldpiyecaicwrawzwflokefqkdwmxejaovvpbflfdtviinbvvtlhhhefmgfsqs", "sxyhcckvyl", "vsaacsybcddxvuzkddjmuivsvtjyanpbydmkcwnkmxvsiantgkvkmqjysclsvd", "sxcghypulvmfqfunxj", "pozekufhlooosxpcggbi", "xzaoxzllcixfqbupqozmzrnugj", "j", "tgslwp", "ntrdkixexajlpjgmcbrqimwtqnzfrqjszeiuvrgzclerzmsnagzaxbredvlrmipzflrzusclckmxphc", "ifdflsywdfizpodsehrrifsvejcxarrxmxyjgbbvqyqvywncphzfmnxhybxpdcozfnzablfx", "uluhplzrsaehaqxfnbcmixueedevhirbwqdyztwaxnkogcauymxgcpabxekib", "agtfkinbdccoemxetbryzpluzlpyzicnfopphrxriqm", "pdympxpwvxwcqaxrvbvyqkrresrjgzgxuyfxtkgldtathokdbyfsqfmitmiyagtqgijaiazvsumeyutbbwxqdshquzrehn", "rqe", "sljsvenhhstnnngzqyo", "dezrzpgldeimxfoqajuhjctgvalwkhkjemjaxumxqmifglbizusuqlttxirpbqbuvauwy", "dkwpyezbmkcskoxxcgrxcewknqgdckjxfyzcmzqcbyeucxbqybxoldogtkmdknsrruvnlfqnpfx", "sjeftmjkuperfynbreycwhuoyqybticswblbrrpugzhlrmiedjqufnehevzqwtaebwvdswsz", "lolnfyliloqmhjmhhohdtgfajjfdjqpubslbsrwitbjmrcegdrdjzvonxaefdvdfcbqmaaks", "qhcoaiocjhuzywkirlblajgeapzajqsoa", "sxrmoqxqbtakuqwmrrkljmegbwbeqbywmlyuprwyhljzejbybxoumidpxdrohwdjoqycpxcmivaulnqzneydwqfsvcxgyyseuk", "yrowy", "dohrzkrzdjehpctnjrvhzojullsiucrhphshwxwicyzkvzbqrztic", "rmshnxtbhsdgkiijrmwulocdzjzpgfyimkjdthuzkhoqgkeawgwincubrloknocxwzgqqcxafksxgzh", "aymovnuhptozhkiyowbeguzlkmrwjnujgjbdne", "abc", "vxoigovwmqizmkwbkktqk", "uokwktdempzloaglvvkqstztmwzcmhgxtoua", "bzwjxqueazlzfojrkbqmhtwrvuwsnfcnylurnddpektekca", "qgndjgvzcyajhgmrrnhdywwdbmkhtthwcfiueuxfldanyrmccwcy"};
        //        String[] words = new String[]{"ruqjwejuanjtiizcmbieobesnjnadzqvqumggblzmkxilgfarnxwpcawtkzxlvugibpidvwtikloeziuxqoi", "os"};
        String chars = "figspbov";

        Solution solution = new Solution();
        System.out.println(solution.countCharacters(words, chars));
    }
}