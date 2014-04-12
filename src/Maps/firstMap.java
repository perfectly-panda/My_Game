package Maps;

import Characters.Bunny;
import Characters.Character;
import Characters.Mouse;
import Characters.ShopKeep;
import Items.BasicPotion;
import Items.Inventory;
import MainFiles.MainClass;
import MainFiles.MapHandler;



public class firstMap extends TheMap {

	public firstMap() {
		
		//row 1
		tileNum[00]=0; tileNum[01]=0; tileNum[02]=0; tileNum[03]=0; tileNum[04]=0; tileNum[05]=0; tileNum[06]=0; tileNum[07]=0;
		tileNum[8]=0; tileNum[9]=0; tileNum[10]=0; tileNum[11]=0; tileNum[12]=0; tileNum[13]=0; tileNum[14]=2; tileNum[15]=2;
		tileNum[16]=2; tileNum[17]=2; tileNum[18]=0; tileNum[19]=0; tileNum[20]=0; tileNum[21]=0; tileNum[22]=0; tileNum[23]=0;
		tileNum[24]=0; tileNum[25]=0; tileNum[26]=0; tileNum[27]=0; tileNum[28]=0; tileNum[29]=0; tileNum[30]=0; tileNum[31]=0;
		
		//row 2
		tileNum[32]=0; tileNum[33]=2; tileNum[34]=2; tileNum[35]=2; tileNum[36]=2; tileNum[37]=2; tileNum[38]=2; tileNum[39]=2;
		tileNum[40]=2; tileNum[41]=2; tileNum[42]=2; tileNum[43]=2; tileNum[44]=2; tileNum[45]=2; tileNum[46]=2; tileNum[47]=2;
		tileNum[48]=2; tileNum[49]=2; tileNum[50]=2; tileNum[51]=2; tileNum[52]=2; tileNum[53]=2; tileNum[54]=2; tileNum[55]=2;
		tileNum[56]=2; tileNum[57]=2; tileNum[58]=2; tileNum[59]=2; tileNum[60]=2; tileNum[61]=2; tileNum[62]=2; tileNum[63]=0;
		
		//row 3
		tileNum[64]=0; tileNum[65]=2; tileNum[66]=2; tileNum[67]=2; tileNum[68]=2; tileNum[69]=2; tileNum[70]=2; tileNum[71]=2;
		tileNum[72]=2; tileNum[73]=2; tileNum[74]=2; tileNum[75]=2; tileNum[76]=2; tileNum[77]=2; tileNum[78]=2; tileNum[79]=2;
		tileNum[80]=2; tileNum[81]=2; tileNum[82]=2; tileNum[83]=2; tileNum[84]=2; tileNum[85]=2; tileNum[86]=2; tileNum[87]=2;
		tileNum[88]=2; tileNum[89]=2; tileNum[90]=2; tileNum[91]=2; tileNum[92]=2; tileNum[93]=2; tileNum[94]=2; tileNum[95]=0;
		
		//row 4
		tileNum[96]=0; tileNum[97]=2; tileNum[98]=2; tileNum[99]=2; tileNum[100]=2; tileNum[101]=2; tileNum[102]=2; tileNum[103]=2;
		tileNum[104]=2; tileNum[105]=2; tileNum[106]=2; tileNum[107]=2; tileNum[108]=2; tileNum[109]=2; tileNum[110]=2; tileNum[111]=2;
		tileNum[112]=2; tileNum[113]=2; tileNum[114]=2; tileNum[115]=2; tileNum[116]=2; tileNum[117]=2; tileNum[118]=2; tileNum[119]=2;
		tileNum[120]=2; tileNum[121]=2; tileNum[122]=2; tileNum[123]=2; tileNum[124]=2; tileNum[125]=2; tileNum[126]=2; tileNum[127]=0;
		
		//row 5
		tileNum[128]=0; tileNum[129]=2; tileNum[130]=2; tileNum[131]=2; tileNum[132]=2; tileNum[133]=2; tileNum[134]=2; tileNum[135]=2;
		tileNum[136]=2; tileNum[137]=2; tileNum[138]=2; tileNum[139]=2; tileNum[140]=2; tileNum[141]=2; tileNum[142]=2; tileNum[143]=2;
		tileNum[144]=2; tileNum[145]=2; tileNum[146]=2; tileNum[147]=2; tileNum[148]=2; tileNum[149]=2; tileNum[150]=2; tileNum[151]=2;
		tileNum[152]=2; tileNum[153]=2; tileNum[154]=2; tileNum[155]=2; tileNum[156]=2; tileNum[157]=2; tileNum[158]=2; tileNum[159]=0;
		
		//row 6
		tileNum[160]=0; tileNum[161]=2; tileNum[162]=2; tileNum[163]=2; tileNum[164]=2; tileNum[165]=0; tileNum[166]=0; tileNum[167]=0;
		tileNum[168]=0; tileNum[169]=0; tileNum[170]=0; tileNum[171]=0; tileNum[172]=0; tileNum[173]=0; tileNum[174]=1; tileNum[175]=1;
		tileNum[176]=1; tileNum[177]=1; tileNum[178]=0; tileNum[179]=0; tileNum[180]=0; tileNum[181]=0; tileNum[182]=0; tileNum[183]=0;
		tileNum[184]=0; tileNum[185]=0; tileNum[186]=0; tileNum[187]=2; tileNum[188]=2; tileNum[189]=2; tileNum[190]=2; tileNum[191]=0;
		
		//row 7
		tileNum[192]=0; tileNum[193]=2; tileNum[194]=2; tileNum[195]=2; tileNum[196]=2; tileNum[197]=0; tileNum[198]=1; tileNum[199]=1;
		tileNum[200]=1; tileNum[201]=1; tileNum[202]=1; tileNum[203]=1; tileNum[204]=1; tileNum[205]=1; tileNum[206]=1; tileNum[207]=1;
		tileNum[208]=1; tileNum[209]=1; tileNum[210]=1; tileNum[211]=1; tileNum[212]=1; tileNum[213]=1; tileNum[214]=1; tileNum[215]=1;
		tileNum[216]=1; tileNum[217]=1; tileNum[218]=0; tileNum[219]=2; tileNum[220]=2; tileNum[221]=2; tileNum[222]=2; tileNum[223]=0;
		
		//row 8
		tileNum[224]=0; tileNum[225]=2; tileNum[226]=2; tileNum[227]=2; tileNum[228]=2; tileNum[229]=0; tileNum[230]=1; tileNum[231]=1;
		tileNum[232]=1; tileNum[233]=1; tileNum[234]=1; tileNum[235]=1; tileNum[236]=1; tileNum[237]=1; tileNum[238]=1; tileNum[239]=1;
		tileNum[240]=1; tileNum[241]=1; tileNum[242]=1; tileNum[243]=1; tileNum[244]=1; tileNum[245]=1; tileNum[246]=1; tileNum[247]=1;
		tileNum[248]=1; tileNum[249]=1; tileNum[250]=0; tileNum[251]=2; tileNum[252]=2; tileNum[253]=2; tileNum[254]=2; tileNum[255]=0;
		
		//row 9
		tileNum[256]=0; tileNum[257]=2; tileNum[258]=2; tileNum[259]=2; tileNum[260]=2; tileNum[261]=0; tileNum[262]=1; tileNum[263]=1;
		tileNum[264]=1; tileNum[265]=1; tileNum[266]=1; tileNum[267]=1; tileNum[268]=1; tileNum[269]=1; tileNum[270]=1; tileNum[271]=1;
		tileNum[272]=1; tileNum[273]=1; tileNum[274]=1; tileNum[275]=1; tileNum[276]=1; tileNum[277]=1; tileNum[278]=1; tileNum[279]=1;
		tileNum[280]=1; tileNum[281]=1; tileNum[282]=0; tileNum[283]=2; tileNum[284]=2; tileNum[285]=2; tileNum[286]=2; tileNum[287]=0;
		
		//row 10
		tileNum[288]=0; tileNum[289]=2; tileNum[290]=2; tileNum[291]=2; tileNum[292]=2; tileNum[293]=0; tileNum[294]=1; tileNum[295]=1;
		tileNum[296]=1; tileNum[297]=1; tileNum[298]=1; tileNum[299]=1; tileNum[300]=1; tileNum[301]=1; tileNum[302]=1; tileNum[303]=1;
		tileNum[304]=1; tileNum[305]=1; tileNum[306]=1; tileNum[307]=1; tileNum[308]=1; tileNum[309]=1; tileNum[310]=1; tileNum[311]=1;
		tileNum[312]=1; tileNum[313]=1; tileNum[314]=0; tileNum[315]=2; tileNum[316]=2; tileNum[317]=2; tileNum[318]=2; tileNum[319]=0;
		
		//row 11
		tileNum[320]=0; tileNum[321]=2; tileNum[322]=2; tileNum[323]=2; tileNum[324]=2; tileNum[325]=1; tileNum[326]=1; tileNum[327]=1;
		tileNum[328]=1; tileNum[329]=1; tileNum[330]=1; tileNum[331]=1; tileNum[332]=1; tileNum[333]=1; tileNum[334]=1; tileNum[335]=1;
		tileNum[336]=1; tileNum[337]=1; tileNum[338]=1; tileNum[339]=1; tileNum[340]=1; tileNum[341]=1; tileNum[342]=1; tileNum[343]=1;
		tileNum[344]=1; tileNum[345]=1; tileNum[346]=1; tileNum[347]=2; tileNum[348]=2; tileNum[349]=2; tileNum[350]=2; tileNum[351]=0;
		
		//row 12
		tileNum[352]=0; tileNum[353]=2; tileNum[354]=2; tileNum[355]=2; tileNum[356]=2; tileNum[357]=1; tileNum[358]=1; tileNum[359]=1;
		tileNum[360]=1; tileNum[361]=1; tileNum[362]=1; tileNum[363]=1; tileNum[364]=1; tileNum[365]=1; tileNum[366]=1; tileNum[367]=1;
		tileNum[368]=1; tileNum[369]=1; tileNum[370]=1; tileNum[371]=1; tileNum[372]=1; tileNum[373]=1; tileNum[374]=1; tileNum[375]=1;
		tileNum[376]=1; tileNum[377]=1; tileNum[378]=1; tileNum[379]=2; tileNum[380]=2; tileNum[381]=2; tileNum[382]=2; tileNum[383]=0;
		
		//row 13
		tileNum[384]=0; tileNum[385]=2; tileNum[386]=2; tileNum[387]=2; tileNum[388]=2; tileNum[389]=1; tileNum[390]=1; tileNum[391]=1;
		tileNum[392]=1; tileNum[393]=1; tileNum[394]=1; tileNum[395]=1; tileNum[396]=1; tileNum[397]=1; tileNum[398]=1; tileNum[399]=1;
		tileNum[400]=1; tileNum[401]=1; tileNum[402]=1; tileNum[403]=1; tileNum[404]=1; tileNum[405]=1; tileNum[406]=1; tileNum[407]=1;
		tileNum[408]=1; tileNum[409]=1; tileNum[410]=1; tileNum[411]=2; tileNum[412]=2; tileNum[413]=2; tileNum[414]=2; tileNum[415]=0;
		
		//row 14
		tileNum[416]=0; tileNum[417]=2; tileNum[418]=2; tileNum[419]=2; tileNum[420]=2; tileNum[421]=1; tileNum[422]=1; tileNum[423]=1;
		tileNum[424]=1; tileNum[425]=1; tileNum[426]=1; tileNum[427]=1; tileNum[428]=1; tileNum[429]=1; tileNum[430]=1; tileNum[431]=1;
		tileNum[432]=1; tileNum[433]=1; tileNum[434]=1; tileNum[435]=1; tileNum[436]=1; tileNum[437]=1; tileNum[438]=1; tileNum[439]=1;
		tileNum[440]=1; tileNum[441]=1; tileNum[442]=1; tileNum[443]=2; tileNum[444]=2; tileNum[445]=2; tileNum[446]=2; tileNum[447]=0;
		
		//row 15
		tileNum[448]=0; tileNum[449]=2; tileNum[450]=2; tileNum[451]=2; tileNum[452]=2; tileNum[453]=0; tileNum[454]=1; tileNum[455]=1;
		tileNum[456]=1; tileNum[457]=1; tileNum[458]=1; tileNum[459]=1; tileNum[460]=1; tileNum[461]=1; tileNum[462]=1; tileNum[463]=1;
		tileNum[464]=1; tileNum[465]=1; tileNum[466]=1; tileNum[467]=1; tileNum[468]=1; tileNum[469]=1; tileNum[470]=1; tileNum[471]=1;
		tileNum[472]=1; tileNum[473]=1; tileNum[474]=0; tileNum[475]=2; tileNum[476]=2; tileNum[477]=2; tileNum[478]=2; tileNum[479]=0;
		
		//row 16
		tileNum[480]=0; tileNum[481]=2; tileNum[482]=2; tileNum[483]=2; tileNum[484]=2; tileNum[485]=0; tileNum[486]=1; tileNum[487]=1;
		tileNum[488]=1; tileNum[489]=1; tileNum[490]=1; tileNum[491]=1; tileNum[492]=1; tileNum[493]=1; tileNum[494]=1; tileNum[495]=1;
		tileNum[496]=1; tileNum[497]=1; tileNum[498]=1; tileNum[499]=1; tileNum[500]=1; tileNum[501]=1; tileNum[502]=1; tileNum[503]=1;
		tileNum[504]=1; tileNum[505]=1; tileNum[506]=0; tileNum[507]=2; tileNum[508]=2; tileNum[509]=2; tileNum[510]=2; tileNum[511]=0;
		
		tileNum[512]=0; tileNum[513]=2; tileNum[514]=2; tileNum[515]=2; tileNum[516]=2; tileNum[517]=0; tileNum[518]=1; tileNum[519]=1;
		tileNum[520]=1; tileNum[521]=1; tileNum[522]=1; tileNum[523]=1; tileNum[524]=1; tileNum[525]=1; tileNum[526]=1; tileNum[527]=1;
		tileNum[528]=1; tileNum[529]=1; tileNum[530]=1; tileNum[531]=1; tileNum[532]=1; tileNum[533]=1; tileNum[534]=1; tileNum[535]=1;
		tileNum[536]=1; tileNum[537]=1; tileNum[538]=0; tileNum[539]=2; tileNum[540]=2; tileNum[541]=2; tileNum[542]=2; tileNum[543]=0;
		
		tileNum[544]=0; tileNum[545]=2; tileNum[546]=2; tileNum[547]=2; tileNum[548]=2; tileNum[549]=0; tileNum[550]=1; tileNum[551]=1;
		tileNum[552]=1; tileNum[553]=1; tileNum[554]=1; tileNum[555]=1; tileNum[556]=1; tileNum[557]=1; tileNum[558]=1; tileNum[559]=1;
		tileNum[560]=1; tileNum[561]=1; tileNum[562]=1; tileNum[563]=1; tileNum[564]=1; tileNum[565]=1; tileNum[566]=1; tileNum[567]=1;
		tileNum[568]=1; tileNum[569]=1; tileNum[570]=0; tileNum[571]=2; tileNum[572]=2; tileNum[573]=2; tileNum[574]=2; tileNum[575]=0;
		
		tileNum[576]=0; tileNum[577]=2; tileNum[578]=2; tileNum[579]=2; tileNum[580]=2; tileNum[581]=0; tileNum[582]=0; tileNum[583]=0;
		tileNum[584]=0; tileNum[585]=0; tileNum[586]=0; tileNum[587]=0; tileNum[588]=0; tileNum[589]=0; tileNum[590]=1; tileNum[591]=1;
		tileNum[592]=1; tileNum[593]=1; tileNum[594]=0; tileNum[595]=0; tileNum[596]=0; tileNum[597]=0; tileNum[598]=0; tileNum[599]=0;
		tileNum[600]=0; tileNum[601]=0; tileNum[602]=0; tileNum[603]=2; tileNum[604]=2; tileNum[605]=2; tileNum[606]=2; tileNum[607]=0;
		
		tileNum[608]=0; tileNum[609]=2; tileNum[610]=2; tileNum[611]=2; tileNum[612]=2; tileNum[613]=2; tileNum[614]=2; tileNum[615]=2;
		tileNum[616]=2; tileNum[617]=2; tileNum[618]=2; tileNum[619]=2; tileNum[620]=2; tileNum[621]=2; tileNum[622]=2; tileNum[623]=2;
		tileNum[624]=2; tileNum[625]=2; tileNum[626]=2; tileNum[627]=2; tileNum[628]=2; tileNum[629]=2; tileNum[630]=2; tileNum[631]=2;
		tileNum[632]=2; tileNum[633]=2; tileNum[634]=2; tileNum[635]=2; tileNum[636]=2; tileNum[637]=2; tileNum[638]=2; tileNum[639]=0;
		
		tileNum[640]=0; tileNum[641]=2; tileNum[642]=2; tileNum[643]=2; tileNum[644]=2; tileNum[645]=2; tileNum[646]=2; tileNum[647]=2;
		tileNum[648]=2; tileNum[649]=2; tileNum[650]=2; tileNum[651]=2; tileNum[652]=2; tileNum[653]=2; tileNum[654]=2; tileNum[655]=2;
		tileNum[656]=2; tileNum[657]=2; tileNum[658]=2; tileNum[659]=2; tileNum[660]=2; tileNum[661]=2; tileNum[662]=2; tileNum[663]=2;
		tileNum[664]=2; tileNum[665]=2; tileNum[666]=2; tileNum[667]=2; tileNum[668]=2; tileNum[669]=2; tileNum[670]=2; tileNum[671]=0;
		
		tileNum[672]=0; tileNum[673]=2; tileNum[674]=2; tileNum[675]=2; tileNum[676]=2; tileNum[677]=2; tileNum[678]=2; tileNum[679]=2;
		tileNum[680]=2; tileNum[681]=2; tileNum[682]=2; tileNum[683]=2; tileNum[684]=2; tileNum[685]=2; tileNum[686]=2; tileNum[687]=2;
		tileNum[688]=2; tileNum[689]=2; tileNum[690]=2; tileNum[691]=2; tileNum[692]=2; tileNum[693]=2; tileNum[694]=2; tileNum[695]=2;
		tileNum[696]=2; tileNum[697]=2; tileNum[698]=2; tileNum[699]=2; tileNum[700]=2; tileNum[701]=2; tileNum[702]=2; tileNum[703]=0;
		
		tileNum[704]=0; tileNum[705]=2; tileNum[706]=2; tileNum[707]=2; tileNum[708]=2; tileNum[709]=2; tileNum[710]=2; tileNum[711]=2;
		tileNum[712]=2; tileNum[713]=2; tileNum[714]=2; tileNum[715]=2; tileNum[716]=2; tileNum[717]=2; tileNum[718]=2; tileNum[719]=2;
		tileNum[720]=2; tileNum[721]=2; tileNum[722]=2; tileNum[723]=2; tileNum[724]=2; tileNum[725]=2; tileNum[726]=2; tileNum[727]=2;
		tileNum[728]=2; tileNum[729]=2; tileNum[730]=2; tileNum[731]=2; tileNum[732]=2; tileNum[733]=2; tileNum[734]=2; tileNum[735]=0;
		
		tileNum[736]=0; tileNum[737]=0; tileNum[738]=0; tileNum[739]=0; tileNum[740]=0; tileNum[741]=0; tileNum[742]=0; tileNum[743]=0;
		tileNum[744]=0; tileNum[745]=0; tileNum[746]=0; tileNum[747]=0; tileNum[748]=0; tileNum[749]=0; tileNum[750]=2; tileNum[751]=2;
		tileNum[752]=2; tileNum[753]=2; tileNum[754]=0; tileNum[755]=0; tileNum[756]=0; tileNum[757]=0; tileNum[758]=0; tileNum[759]=0;
		tileNum[760]=0; tileNum[761]=0; tileNum[762]=0; tileNum[763]=0; tileNum[764]=0; tileNum[765]=0; tileNum[766]=0; tileNum[767]=0;
		
		
		tileMap = loadMap(tileNum);
				
	}
	
	public void checkExit(int x, int y, Character c, MapHandler mh, MainClass mc)
	{
		//System.out.println("x = " + c.getX() + " y = " + c.getY());
		if (y <= 0 && x>= 350 && x <= 425)
		{
			//System.out.println("jump");
			c.setY(550);
			mh.setCurMap(1, mc);
			System.out.println(mh.getCurMap());
		}
		else if (y >= 570 && x>= 350 && x <= 425)
		{
			//System.out.println("jump");
			c.setY(25);
			mh.setCurMap(1, mc);
			//System.out.println(mh.getCurMap());
		}
	}

	public void onLoad(MapHandler mh, MainClass mc){
		//System.out.println("map 1");
		Inventory inv = new Inventory(1);
		BasicPotion p = new BasicPotion();
		inv.setInventorySlot(p, 0);
		mh.monsters[0] = new Bunny();
		mh.monsters[0].createMonster(mh.mapGrid(2), mh.mapGrid(2), mc);
		mh.monsters[1] = new Mouse();
		mh.monsters[1].createMonster(mh.mapGrid(10), mh.mapGrid(10), mc);
		//mh.npcs[0] = new ShopKeep(inv, "Bob", mc);
	}
}
