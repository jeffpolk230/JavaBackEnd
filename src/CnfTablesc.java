import java.util.Arrays;

public class CnfTablesc implements Grammar<Pair, CatTag>{
CatTag[] first, second;


public String getDesc (CatTag c){
	switch(c){
	case CAT_Program:
		return "Program";
	case CAT_External_declaration_List:
		return "[External_declaration]";
	case CAT_External_declaration:
		return "External_declaration";
	case CAT_Function_def:
		return "Function_def";
	case CAT_0:
		return "3-prefix of OldFunc ([Declaration_specifier] Declarator [Dec])";
	case CAT_1:
		return "2-prefix of OldFunc ([Declaration_specifier] Declarator)";
	case CAT_2:
		return "2-prefix of NewFunc ([Declaration_specifier] Declarator)";
	case CAT_3:
		return "2-prefix of OldFuncInt (Declarator [Dec])";
	case CAT_Dec:
		return "Dec";
	case CAT_4:
		return "2-prefix of Declarators ([Declaration_specifier] [Init_declarator])";
	case CAT_Dec_List:
		return "[Dec]";
	case CAT_Declaration_specifier_List:
		return "[Declaration_specifier]";
	case CAT_Declaration_specifier:
		return "Declaration_specifier";
	case CAT_Init_declarator_List:
		return "[Init_declarator]";
	case CAT_5:
		return "2-prefix of (:) (Init_declarator ',')";
	case CAT_Init_declarator:
		return "Init_declarator";
	case CAT_6:
		return "2-prefix of InitDecl (Declarator '=')";
	case CAT_Type_specifier:
		return "Type_specifier";
	case CAT_Storage_class_specifier:
		return "Storage_class_specifier";
	case CAT_Type_qualifier:
		return "Type_qualifier";
	case CAT_Struct_or_union_spec:
		return "Struct_or_union_spec";
	case CAT_7:
		return "4-prefix of Tag (Struct_or_union Ident '{' [Struct_dec])";
	case CAT_8:
		return "3-prefix of Tag (Struct_or_union Ident '{')";
	case CAT_9:
		return "2-prefix of Tag (Struct_or_union Ident)";
	case CAT_10:
		return "3-prefix of Unique (Struct_or_union '{' [Struct_dec])";
	case CAT_11:
		return "2-prefix of Unique (Struct_or_union '{')";
	case CAT_Struct_or_union:
		return "Struct_or_union";
	case CAT_Struct_dec_List:
		return "[Struct_dec]";
	case CAT_Struct_dec:
		return "Struct_dec";
	case CAT_12:
		return "2-prefix of Structen ([Spec_qual] [Struct_declarator])";
	case CAT_Spec_qual_List:
		return "[Spec_qual]";
	case CAT_Spec_qual:
		return "Spec_qual";
	case CAT_Struct_declarator_List:
		return "[Struct_declarator]";
	case CAT_13:
		return "2-prefix of (:) (Struct_declarator ',')";
	case CAT_Struct_declarator:
		return "Struct_declarator";
	case CAT_14:
		return "2-prefix of DecField (Declarator ':')";
	case CAT_Enum_specifier:
		return "Enum_specifier";
	case CAT_15:
		return "3-prefix of EnumDec ('enum' '{' [Enumerator])";
	case CAT_16:
		return "2-prefix of EnumDec ('enum' '{')";
	case CAT_17:
		return "4-prefix of EnumName ('enum' Ident '{' [Enumerator])";
	case CAT_18:
		return "3-prefix of EnumName ('enum' Ident '{')";
	case CAT_19:
		return "2-prefix of EnumName ('enum' Ident)";
	case CAT_Enumerator_List:
		return "[Enumerator]";
	case CAT_20:
		return "2-prefix of (:) (Enumerator ',')";
	case CAT_Enumerator:
		return "Enumerator";
	case CAT_21:
		return "2-prefix of EnumInit (Ident '=')";
	case CAT_Declarator:
		return "Declarator";
	case CAT_Direct_declarator:
		return "Direct_declarator";
	case CAT_22:
		return "2-prefix of ParenDecl ('(' Declarator)";
	case CAT_23:
		return "3-prefix of InnitArray (Direct_declarator '[' Constant_expression)";
	case CAT_24:
		return "2-prefix of InnitArray (Direct_declarator '[')";
	case CAT_25:
		return "2-prefix of Incomplete (Direct_declarator '[')";
	case CAT_26:
		return "3-prefix of NewFuncDec (Direct_declarator '(' Parameter_type)";
	case CAT_27:
		return "2-prefix of NewFuncDec (Direct_declarator '(')";
	case CAT_28:
		return "3-prefix of OldFuncDef (Direct_declarator '(' [Ident])";
	case CAT_29:
		return "2-prefix of OldFuncDef (Direct_declarator '(')";
	case CAT_30:
		return "2-prefix of OldFuncDec (Direct_declarator '(')";
	case CAT_Pointer:
		return "Pointer";
	case CAT_31:
		return "2-prefix of PointQualPoint ('*' [Type_qualifier])";
	case CAT_Type_qualifier_List:
		return "[Type_qualifier]";
	case CAT_Parameter_type:
		return "Parameter_type";
	case CAT_32:
		return "2-prefix of More (Parameter_declarations ',')";
	case CAT_Parameter_declarations:
		return "Parameter_declarations";
	case CAT_33:
		return "2-prefix of MoreParamDec (Parameter_declarations ',')";
	case CAT_Parameter_declaration:
		return "Parameter_declaration";
	case CAT_Ident_List:
		return "[Ident]";
	case CAT_34:
		return "2-prefix of (:) (Ident ',')";
	case CAT_Initz:
		return "Initz";
	case CAT_35:
		return "2-prefix of InitListOne ('{' Initializers)";
	case CAT_36:
		return "3-prefix of InitListTwo ('{' Initializers ',')";
	case CAT_37:
		return "2-prefix of InitListTwo ('{' Initializers)";
	case CAT_Initializers:
		return "Initializers";
	case CAT_38:
		return "2-prefix of MoreInit (Initializers ',')";
	case CAT_Type_name:
		return "Type_name";
	case CAT_Abstract_declarator:
		return "Abstract_declarator";
	case CAT_Dir_abs_dec:
		return "Dir_abs_dec";
	case CAT_39:
		return "2-prefix of WithinParentes ('(' Abstract_declarator)";
	case CAT_40:
		return "2-prefix of InitiatedArray ('[' Constant_expression)";
	case CAT_41:
		return "2-prefix of UnInitiated (Dir_abs_dec '[')";
	case CAT_42:
		return "3-prefix of Initiated (Dir_abs_dec '[' Constant_expression)";
	case CAT_43:
		return "2-prefix of Initiated (Dir_abs_dec '[')";
	case CAT_44:
		return "2-prefix of NewFunction ('(' Parameter_type)";
	case CAT_45:
		return "2-prefix of OldFuncExpr (Dir_abs_dec '(')";
	case CAT_46:
		return "3-prefix of NewFuncExpr (Dir_abs_dec '(' Parameter_type)";
	case CAT_47:
		return "2-prefix of NewFuncExpr (Dir_abs_dec '(')";
	case CAT_Stm:
		return "Stm";
	case CAT_Labeled_stm:
		return "Labeled_stm";
	case CAT_48:
		return "2-prefix of SlabelOne (Ident ':')";
	case CAT_49:
		return "3-prefix of SlabelTwo ('case' Constant_expression ':')";
	case CAT_50:
		return "2-prefix of SlabelTwo ('case' Constant_expression)";
	case CAT_51:
		return "2-prefix of SlabelThree ('default' ':')";
	case CAT_Compound_stm:
		return "Compound_stm";
	case CAT_52:
		return "2-prefix of ScompTwo ('{' [Stm])";
	case CAT_53:
		return "2-prefix of ScompThree ('{' [Dec])";
	case CAT_54:
		return "3-prefix of ScompFour ('{' [Dec] [Stm])";
	case CAT_55:
		return "2-prefix of ScompFour ('{' [Dec])";
	case CAT_Expression_stm:
		return "Expression_stm";
	case CAT_Selection_stm:
		return "Selection_stm";
	case CAT_56:
		return "4-prefix of SselOne ('if' '(' Exp ')')";
	case CAT_57:
		return "3-prefix of SselOne ('if' '(' Exp)";
	case CAT_58:
		return "2-prefix of SselOne ('if' '(')";
	case CAT_59:
		return "6-prefix of SselTwo ('if' '(' Exp ')' Stm 'else')";
	case CAT_60:
		return "5-prefix of SselTwo ('if' '(' Exp ')' Stm)";
	case CAT_61:
		return "4-prefix of SselTwo ('if' '(' Exp ')')";
	case CAT_62:
		return "3-prefix of SselTwo ('if' '(' Exp)";
	case CAT_63:
		return "2-prefix of SselTwo ('if' '(')";
	case CAT_64:
		return "4-prefix of SselThree ('switch' '(' Exp ')')";
	case CAT_65:
		return "3-prefix of SselThree ('switch' '(' Exp)";
	case CAT_66:
		return "2-prefix of SselThree ('switch' '(')";
	case CAT_Iter_stm:
		return "Iter_stm";
	case CAT_67:
		return "4-prefix of SiterOne ('while' '(' Exp ')')";
	case CAT_68:
		return "3-prefix of SiterOne ('while' '(' Exp)";
	case CAT_69:
		return "2-prefix of SiterOne ('while' '(')";
	case CAT_70:
		return "6-prefix of SiterTwo ('do' Stm 'while' '(' Exp ')')";
	case CAT_71:
		return "5-prefix of SiterTwo ('do' Stm 'while' '(' Exp)";
	case CAT_72:
		return "4-prefix of SiterTwo ('do' Stm 'while' '(')";
	case CAT_73:
		return "3-prefix of SiterTwo ('do' Stm 'while')";
	case CAT_74:
		return "2-prefix of SiterTwo ('do' Stm)";
	case CAT_75:
		return "5-prefix of SiterThree ('for' '(' Expression_stm Expression_stm ')')";
	case CAT_76:
		return "4-prefix of SiterThree ('for' '(' Expression_stm Expression_stm)";
	case CAT_77:
		return "3-prefix of SiterThree ('for' '(' Expression_stm)";
	case CAT_78:
		return "2-prefix of SiterThree ('for' '(')";
	case CAT_79:
		return "6-prefix of SiterFour ('for' '(' Expression_stm Expression_stm Exp ')')";
	case CAT_80:
		return "5-prefix of SiterFour ('for' '(' Expression_stm Expression_stm Exp)";
	case CAT_81:
		return "4-prefix of SiterFour ('for' '(' Expression_stm Expression_stm)";
	case CAT_82:
		return "3-prefix of SiterFour ('for' '(' Expression_stm)";
	case CAT_83:
		return "2-prefix of SiterFour ('for' '(')";
	case CAT_Jump_stm:
		return "Jump_stm";
	case CAT_84:
		return "2-prefix of SjumpOne ('goto' Ident)";
	case CAT_85:
		return "2-prefix of SjumpFive ('return' Exp)";
	case CAT_Stm_List:
		return "[Stm]";
	case CAT_Exp:
		return "Exp";
	case CAT_86:
		return "2-prefix of Ecomma (Exp ',')";
	case CAT_Exp2:
		return "Exp2";
	case CAT_87:
		return "2-prefix of Eassign (Exp15 Assignment_op)";
	case CAT_Exp3:
		return "Exp3";
	case CAT_88:
		return "4-prefix of Econdition (Exp4 '?' Exp ':')";
	case CAT_89:
		return "3-prefix of Econdition (Exp4 '?' Exp)";
	case CAT_90:
		return "2-prefix of Econdition (Exp4 '?')";
	case CAT_Exp4:
		return "Exp4";
	case CAT_91:
		return "2-prefix of Elor (Exp4 '||')";
	case CAT_Exp5:
		return "Exp5";
	case CAT_92:
		return "2-prefix of Eland (Exp5 '&&')";
	case CAT_Exp6:
		return "Exp6";
	case CAT_93:
		return "2-prefix of Ebitor (Exp6 '|')";
	case CAT_Exp7:
		return "Exp7";
	case CAT_94:
		return "2-prefix of Ebitexor (Exp7 '^')";
	case CAT_Exp8:
		return "Exp8";
	case CAT_95:
		return "2-prefix of Ebitand (Exp8 '&')";
	case CAT_Exp9:
		return "Exp9";
	case CAT_96:
		return "2-prefix of Eeq (Exp9 '==')";
	case CAT_97:
		return "2-prefix of Eneq (Exp9 '!=')";
	case CAT_Exp10:
		return "Exp10";
	case CAT_98:
		return "2-prefix of Elthen (Exp10 '<')";
	case CAT_99:
		return "2-prefix of Egrthen (Exp10 '>')";
	case CAT_100:
		return "2-prefix of Ele (Exp10 '<=')";
	case CAT_101:
		return "2-prefix of Ege (Exp10 '>=')";
	case CAT_Exp11:
		return "Exp11";
	case CAT_102:
		return "2-prefix of Eleft (Exp11 '<<')";
	case CAT_103:
		return "2-prefix of Eright (Exp11 '>>')";
	case CAT_Exp12:
		return "Exp12";
	case CAT_104:
		return "2-prefix of Eplus (Exp12 '+')";
	case CAT_105:
		return "2-prefix of Eminus (Exp12 '-')";
	case CAT_Exp13:
		return "Exp13";
	case CAT_106:
		return "2-prefix of Etimes (Exp13 '*')";
	case CAT_107:
		return "2-prefix of Ediv (Exp13 '/')";
	case CAT_108:
		return "2-prefix of Emod (Exp13 '%')";
	case CAT_Exp14:
		return "Exp14";
	case CAT_109:
		return "3-prefix of Etypeconv ('(' Type_name ')')";
	case CAT_110:
		return "2-prefix of Etypeconv ('(' Type_name)";
	case CAT_Exp15:
		return "Exp15";
	case CAT_111:
		return "3-prefix of Ebytestype ('sizeof' '(' Type_name)";
	case CAT_112:
		return "2-prefix of Ebytestype ('sizeof' '(')";
	case CAT_Exp16:
		return "Exp16";
	case CAT_113:
		return "3-prefix of Earray (Exp16 '[' Exp)";
	case CAT_114:
		return "2-prefix of Earray (Exp16 '[')";
	case CAT_115:
		return "2-prefix of Efunk (Exp16 '(')";
	case CAT_116:
		return "3-prefix of Efunkpar (Exp16 '(' [Exp2])";
	case CAT_117:
		return "2-prefix of Efunkpar (Exp16 '(')";
	case CAT_118:
		return "2-prefix of Eselect (Exp16 '.')";
	case CAT_119:
		return "2-prefix of Epoint (Exp16 '->')";
	case CAT_Exp17:
		return "Exp17";
	case CAT_Constant:
		return "Constant";
	case CAT_Constant_expression:
		return "Constant_expression";
	case CAT_120:
		return "2-prefix of id ('(' Exp)";
	case CAT_Unary_operator:
		return "Unary_operator";
	case CAT_Exp2_List:
		return "[Exp2]";
	case CAT_121:
		return "2-prefix of (:) (Exp2 ',')";
	case CAT_Assignment_op:
		return "Assignment_op";
	case CAT_Ident:
		return "Ident";
	case CAT_String:
		return "String";
	case CAT_Double:
		return "Double";
	case CAT_Char:
		return "Char";
	case CAT_Integer:
		return "Integer";
	case CAT_Unsigned:
		return "Unsigned";
	case CAT_Long:
		return "Long";
	case CAT_UnsignedLong:
		return "UnsignedLong";
	case CAT_Hexadecimal:
		return "Hexadecimal";
	case CAT_HexUnsigned:
		return "HexUnsigned";
	case CAT_HexLong:
		return "HexLong";
	case CAT_HexUnsLong:
		return "HexUnsLong";
	case CAT_Octal:
		return "Octal";
	case CAT_OctalUnsigned:
		return "OctalUnsigned";
	case CAT_OctalLong:
		return "OctalLong";
	case CAT_OctalUnsLong:
		return "OctalUnsLong";
	case CAT_CDouble:
		return "CDouble";
	case CAT_CFloat:
		return "CFloat";
	case CAT_CLongDouble:
		return "CLongDouble";
	case TOK_33:
		return "token !";
	case TOK_3361:
		return "token !=";
	case TOK_37:
		return "token %";
	case TOK_3761:
		return "token %=";
	case TOK_38:
		return "token &";
	case TOK_3838:
		return "token &&";
	case TOK_3861:
		return "token &=";
	case TOK_40:
		return "token (";
	case TOK_41:
		return "token )";
	case TOK_42:
		return "token *";
	case TOK_4261:
		return "token *=";
	case TOK_43:
		return "token +";
	case TOK_4343:
		return "token ++";
	case TOK_4361:
		return "token +=";
	case TOK_44:
		return "token ,";
	case TOK_45:
		return "token -";
	case TOK_4545:
		return "token --";
	case TOK_4561:
		return "token -=";
	case TOK_4562:
		return "token ->";
	case TOK_46:
		return "token .";
	case TOK_464646:
		return "token ...";
	case TOK_47:
		return "token /";
	case TOK_4761:
		return "token /=";
	case TOK_58:
		return "token :";
	case TOK_59:
		return "token ;";
	case TOK_60:
		return "token <";
	case TOK_6060:
		return "token <<";
	case TOK_606061:
		return "token <<=";
	case TOK_6061:
		return "token <=";
	case TOK_61:
		return "token =";
	case TOK_6161:
		return "token ==";
	case TOK_62:
		return "token >";
	case TOK_6261:
		return "token >=";
	case TOK_6262:
		return "token >>";
	case TOK_626261:
		return "token >>=";
	case TOK_63:
		return "token ?";
	case TOK_Typedef_name:
		return "token Typedef_name";
	case TOK_:
		return "token [";
	case TOK__List:
		return "token ]";
	case TOK_94:
		return "token ^";
	case TOK_9461:
		return "token ^=";
	case TOK_auto:
		return "token auto";
	case TOK_break:
		return "token break";
	case TOK_case:
		return "token case";
	case TOK_char:
		return "token char";
	case TOK_const:
		return "token const";
	case TOK_continue:
		return "token continue";
	case TOK_default:
		return "token default";
	case TOK_do:
		return "token do";
	case TOK_double:
		return "token double";
	case TOK_else:
		return "token else";
	case TOK_enum:
		return "token enum";
	case TOK_extern:
		return "token extern";
	case TOK_float:
		return "token float";
	case TOK_for:
		return "token for";
	case TOK_goto:
		return "token goto";
	case TOK_if:
		return "token if";
	case TOK_int:
		return "token int";
	case TOK_long:
		return "token long";
	case TOK_register:
		return "token register";
	case TOK_return:
		return "token return";
	case TOK_short:
		return "token short";
	case TOK_signed:
		return "token signed";
	case TOK_sizeof:
		return "token sizeof";
	case TOK_static:
		return "token static";
	case TOK_struct:
		return "token struct";
	case TOK_switch:
		return "token switch";
	case TOK_typedef:
		return "token typedef";
	case TOK_union:
		return "token union";
	case TOK_unsigned:
		return "token unsigned";
	case TOK_void:
		return "token void";
	case TOK_volatile:
		return "token volatile";
	case TOK_while:
		return "token while";
	case TOK_OPEN_:
		return "token {";
	case TOK_124:
		return "token |";
	case TOK_12461:
		return "token |=";
	case TOK_124124:
		return "token ||";
	case TOK_CLOS_:
		return "token }";
	case TOK_126:
		return "token ~";
	default: return " Error, allSyms mismatch";
	}
}

public Pair getCombine (boolean p, CatTag r1,CatTag r2){
	switch(r1){
	case CAT_0:
		switch(r2){
			case CAT_Compound_stm:
			first = new CatTag[]{ CatTag.CAT_External_declaration /* \x y -> unsafeCoerce# (Afunc (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Program /* \x y -> unsafeCoerce# (Progr ((:[]) (Afunc (unsafeCoerce# (x) (unsafeCoerce# (y))))))*/,};second = new CatTag[]{ CatTag.CAT_External_declaration_List /* \x y -> unsafeCoerce# ((:[]) (Afunc (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_1:
		switch(r2){
			case CAT_Dec_List:
			first = new CatTag[]{ CatTag.CAT_0 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_10:
		switch(r2){
			case TOK_CLOS_:
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* \x y -> unsafeCoerce# (Type (Tstruct (unsafeCoerce# (x))))*/, CatTag.CAT_Spec_qual /* \x y -> unsafeCoerce# (TypeSpec (Tstruct (unsafeCoerce# (x))))*/, CatTag.CAT_Declaration_specifier_List /* \x y -> unsafeCoerce# ((:[]) (Type (Tstruct (unsafeCoerce# (x)))))*/, CatTag.CAT_Spec_qual_List /* \x y -> unsafeCoerce# ((:[]) (TypeSpec (Tstruct (unsafeCoerce# (x)))))*/, CatTag.CAT_Parameter_declarations /* \x y -> unsafeCoerce# (ParamDec (OnlyType ((:[]) (Type (Tstruct (unsafeCoerce# (x)))))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* \x y -> unsafeCoerce# ((:[]) (Type (Tstruct (unsafeCoerce# (x)))))*/, CatTag.CAT_Spec_qual_List /* \x y -> unsafeCoerce# ((:[]) (TypeSpec (Tstruct (unsafeCoerce# (x)))))*/, CatTag.CAT_Parameter_declaration /* \x y -> unsafeCoerce# (OnlyType ((:[]) (Type (Tstruct (unsafeCoerce# (x))))))*/, CatTag.CAT_Type_name /* \x y -> unsafeCoerce# (PlainType ((:[]) (TypeSpec (Tstruct (unsafeCoerce# (x))))))*/, CatTag.CAT_Parameter_type /* \x y -> unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Type (Tstruct (unsafeCoerce# (x))))))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_100:
		switch(r2){
			case CAT_Exp11:
			first = new CatTag[]{ CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_101:
		switch(r2){
			case CAT_Exp11:
			first = new CatTag[]{ CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_102:
		switch(r2){
			case CAT_Exp12:
			first = new CatTag[]{ CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_103:
		switch(r2){
			case CAT_Exp12:
			first = new CatTag[]{ CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_104:
		switch(r2){
			case CAT_Exp13:
			first = new CatTag[]{ CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_105:
		switch(r2){
			case CAT_Exp13:
			first = new CatTag[]{ CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_106:
		switch(r2){
			case CAT_Exp14:
			first = new CatTag[]{ CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_107:
		switch(r2){
			case CAT_Exp14:
			first = new CatTag[]{ CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_108:
		switch(r2){
			case CAT_Exp14:
			first = new CatTag[]{ CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_109:
		switch(r2){
			case CAT_Exp14:
			first = new CatTag[]{ CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp14 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_11:
		switch(r2){
			case CAT_Struct_dec_List:
			first = new CatTag[]{ CatTag.CAT_10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_110:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_109 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_111:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x))))*/,};second = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp14 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x)))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x)))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_112:
		switch(r2){
			case CAT_Type_name:
			first = new CatTag[]{ CatTag.CAT_111 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_113:
		switch(r2){
			case TOK__List:
			first = new CatTag[]{ CatTag.CAT_Exp16 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x))))*/,};second = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp14 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x)))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x)))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_114:
		switch(r2){
			case CAT_Exp:
			first = new CatTag[]{ CatTag.CAT_113 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_115:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_Exp16 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x))))*/,};second = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp14 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x)))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x)))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_116:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_Exp16 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x))))*/,};second = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp14 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x)))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x)))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_117:
		switch(r2){
			case CAT_Exp2_List:
			first = new CatTag[]{ CatTag.CAT_116 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_118:
		switch(r2){
			case CAT_Ident:
			first = new CatTag[]{ CatTag.CAT_Exp16 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp14 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_119:
		switch(r2){
			case CAT_Ident:
			first = new CatTag[]{ CatTag.CAT_Exp16 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp14 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_12:
		switch(r2){
			case TOK_59:
			first = new CatTag[]{ CatTag.CAT_Struct_dec /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ CatTag.CAT_Struct_dec_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_120:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_Exp16 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x))))*/,};second = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp14 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x)))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x)))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_121:
		switch(r2){
			case CAT_Exp2_List:
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_13:
		switch(r2){
			case CAT_Struct_declarator_List:
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Struct_declarator_List /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_14:
		switch(r2){
			case CAT_Constant_expression:
			first = new CatTag[]{ CatTag.CAT_Struct_declarator /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ CatTag.CAT_Struct_declarator_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_15:
		switch(r2){
			case TOK_CLOS_:
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* \x y -> unsafeCoerce# (Type (Tenum (unsafeCoerce# (x))))*/, CatTag.CAT_Spec_qual /* \x y -> unsafeCoerce# (TypeSpec (Tenum (unsafeCoerce# (x))))*/, CatTag.CAT_Declaration_specifier_List /* \x y -> unsafeCoerce# ((:[]) (Type (Tenum (unsafeCoerce# (x)))))*/, CatTag.CAT_Spec_qual_List /* \x y -> unsafeCoerce# ((:[]) (TypeSpec (Tenum (unsafeCoerce# (x)))))*/, CatTag.CAT_Parameter_declarations /* \x y -> unsafeCoerce# (ParamDec (OnlyType ((:[]) (Type (Tenum (unsafeCoerce# (x)))))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* \x y -> unsafeCoerce# ((:[]) (Type (Tenum (unsafeCoerce# (x)))))*/, CatTag.CAT_Spec_qual_List /* \x y -> unsafeCoerce# ((:[]) (TypeSpec (Tenum (unsafeCoerce# (x)))))*/, CatTag.CAT_Parameter_declaration /* \x y -> unsafeCoerce# (OnlyType ((:[]) (Type (Tenum (unsafeCoerce# (x))))))*/, CatTag.CAT_Type_name /* \x y -> unsafeCoerce# (PlainType ((:[]) (TypeSpec (Tenum (unsafeCoerce# (x))))))*/, CatTag.CAT_Parameter_type /* \x y -> unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Type (Tenum (unsafeCoerce# (x))))))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_16:
		switch(r2){
			case CAT_Enumerator_List:
			first = new CatTag[]{ CatTag.CAT_15 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_17:
		switch(r2){
			case TOK_CLOS_:
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* \x y -> unsafeCoerce# (Type (Tenum (unsafeCoerce# (x))))*/, CatTag.CAT_Spec_qual /* \x y -> unsafeCoerce# (TypeSpec (Tenum (unsafeCoerce# (x))))*/, CatTag.CAT_Declaration_specifier_List /* \x y -> unsafeCoerce# ((:[]) (Type (Tenum (unsafeCoerce# (x)))))*/, CatTag.CAT_Spec_qual_List /* \x y -> unsafeCoerce# ((:[]) (TypeSpec (Tenum (unsafeCoerce# (x)))))*/, CatTag.CAT_Parameter_declarations /* \x y -> unsafeCoerce# (ParamDec (OnlyType ((:[]) (Type (Tenum (unsafeCoerce# (x)))))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* \x y -> unsafeCoerce# ((:[]) (Type (Tenum (unsafeCoerce# (x)))))*/, CatTag.CAT_Spec_qual_List /* \x y -> unsafeCoerce# ((:[]) (TypeSpec (Tenum (unsafeCoerce# (x)))))*/, CatTag.CAT_Parameter_declaration /* \x y -> unsafeCoerce# (OnlyType ((:[]) (Type (Tenum (unsafeCoerce# (x))))))*/, CatTag.CAT_Type_name /* \x y -> unsafeCoerce# (PlainType ((:[]) (TypeSpec (Tenum (unsafeCoerce# (x))))))*/, CatTag.CAT_Parameter_type /* \x y -> unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Type (Tenum (unsafeCoerce# (x))))))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_18:
		switch(r2){
			case CAT_Enumerator_List:
			first = new CatTag[]{ CatTag.CAT_17 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_19:
		switch(r2){
			case TOK_OPEN_:
			first = new CatTag[]{ CatTag.CAT_18 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_2:
		switch(r2){
			case CAT_Compound_stm:
			first = new CatTag[]{ CatTag.CAT_External_declaration /* \x y -> unsafeCoerce# (Afunc (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Program /* \x y -> unsafeCoerce# (Progr ((:[]) (Afunc (unsafeCoerce# (x) (unsafeCoerce# (y))))))*/,};second = new CatTag[]{ CatTag.CAT_External_declaration_List /* \x y -> unsafeCoerce# ((:[]) (Afunc (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_20:
		switch(r2){
			case CAT_Enumerator_List:
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Enumerator_List /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_21:
		switch(r2){
			case CAT_Constant_expression:
			first = new CatTag[]{ CatTag.CAT_Enumerator /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ CatTag.CAT_Enumerator_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_22:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_Direct_declarator /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Declarator /* \x y -> unsafeCoerce# (NoPointer (unsafeCoerce# (x)))*/, CatTag.CAT_Struct_declarator /* \x y -> unsafeCoerce# (Decl (NoPointer (unsafeCoerce# (x))))*/, CatTag.CAT_Init_declarator /* \x y -> unsafeCoerce# (OnlyDecl (NoPointer (unsafeCoerce# (x))))*/,};second = new CatTag[]{ CatTag.CAT_Direct_declarator /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Declarator /* \x y -> unsafeCoerce# (NoPointer (unsafeCoerce# (x)))*/, CatTag.CAT_Struct_declarator_List /* \x y -> unsafeCoerce# ((:[]) (Decl (NoPointer (unsafeCoerce# (x)))))*/, CatTag.CAT_Init_declarator_List /* \x y -> unsafeCoerce# ((:[]) (OnlyDecl (NoPointer (unsafeCoerce# (x)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_23:
		switch(r2){
			case TOK__List:
			first = new CatTag[]{ CatTag.CAT_Direct_declarator /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Declarator /* \x y -> unsafeCoerce# (NoPointer (unsafeCoerce# (x)))*/, CatTag.CAT_Struct_declarator /* \x y -> unsafeCoerce# (Decl (NoPointer (unsafeCoerce# (x))))*/, CatTag.CAT_Init_declarator /* \x y -> unsafeCoerce# (OnlyDecl (NoPointer (unsafeCoerce# (x))))*/,};second = new CatTag[]{ CatTag.CAT_Direct_declarator /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Declarator /* \x y -> unsafeCoerce# (NoPointer (unsafeCoerce# (x)))*/, CatTag.CAT_Struct_declarator_List /* \x y -> unsafeCoerce# ((:[]) (Decl (NoPointer (unsafeCoerce# (x)))))*/, CatTag.CAT_Init_declarator_List /* \x y -> unsafeCoerce# ((:[]) (OnlyDecl (NoPointer (unsafeCoerce# (x)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_24:
		switch(r2){
			case CAT_Constant_expression:
			first = new CatTag[]{ CatTag.CAT_23 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_25:
		switch(r2){
			case TOK__List:
			first = new CatTag[]{ CatTag.CAT_Direct_declarator /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Declarator /* \x y -> unsafeCoerce# (NoPointer (unsafeCoerce# (x)))*/, CatTag.CAT_Struct_declarator /* \x y -> unsafeCoerce# (Decl (NoPointer (unsafeCoerce# (x))))*/, CatTag.CAT_Init_declarator /* \x y -> unsafeCoerce# (OnlyDecl (NoPointer (unsafeCoerce# (x))))*/,};second = new CatTag[]{ CatTag.CAT_Direct_declarator /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Declarator /* \x y -> unsafeCoerce# (NoPointer (unsafeCoerce# (x)))*/, CatTag.CAT_Struct_declarator_List /* \x y -> unsafeCoerce# ((:[]) (Decl (NoPointer (unsafeCoerce# (x)))))*/, CatTag.CAT_Init_declarator_List /* \x y -> unsafeCoerce# ((:[]) (OnlyDecl (NoPointer (unsafeCoerce# (x)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_26:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_Direct_declarator /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Declarator /* \x y -> unsafeCoerce# (NoPointer (unsafeCoerce# (x)))*/, CatTag.CAT_Struct_declarator /* \x y -> unsafeCoerce# (Decl (NoPointer (unsafeCoerce# (x))))*/, CatTag.CAT_Init_declarator /* \x y -> unsafeCoerce# (OnlyDecl (NoPointer (unsafeCoerce# (x))))*/,};second = new CatTag[]{ CatTag.CAT_Direct_declarator /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Declarator /* \x y -> unsafeCoerce# (NoPointer (unsafeCoerce# (x)))*/, CatTag.CAT_Struct_declarator_List /* \x y -> unsafeCoerce# ((:[]) (Decl (NoPointer (unsafeCoerce# (x)))))*/, CatTag.CAT_Init_declarator_List /* \x y -> unsafeCoerce# ((:[]) (OnlyDecl (NoPointer (unsafeCoerce# (x)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_27:
		switch(r2){
			case CAT_Parameter_type:
			first = new CatTag[]{ CatTag.CAT_26 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_28:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_Direct_declarator /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Declarator /* \x y -> unsafeCoerce# (NoPointer (unsafeCoerce# (x)))*/, CatTag.CAT_Struct_declarator /* \x y -> unsafeCoerce# (Decl (NoPointer (unsafeCoerce# (x))))*/, CatTag.CAT_Init_declarator /* \x y -> unsafeCoerce# (OnlyDecl (NoPointer (unsafeCoerce# (x))))*/,};second = new CatTag[]{ CatTag.CAT_Direct_declarator /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Declarator /* \x y -> unsafeCoerce# (NoPointer (unsafeCoerce# (x)))*/, CatTag.CAT_Struct_declarator_List /* \x y -> unsafeCoerce# ((:[]) (Decl (NoPointer (unsafeCoerce# (x)))))*/, CatTag.CAT_Init_declarator_List /* \x y -> unsafeCoerce# ((:[]) (OnlyDecl (NoPointer (unsafeCoerce# (x)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_29:
		switch(r2){
			case CAT_Ident_List:
			first = new CatTag[]{ CatTag.CAT_28 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_3:
		switch(r2){
			case CAT_Compound_stm:
			first = new CatTag[]{ CatTag.CAT_External_declaration /* \x y -> unsafeCoerce# (Afunc (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Program /* \x y -> unsafeCoerce# (Progr ((:[]) (Afunc (unsafeCoerce# (x) (unsafeCoerce# (y))))))*/,};second = new CatTag[]{ CatTag.CAT_External_declaration_List /* \x y -> unsafeCoerce# ((:[]) (Afunc (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_30:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_Direct_declarator /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Declarator /* \x y -> unsafeCoerce# (NoPointer (unsafeCoerce# (x)))*/, CatTag.CAT_Struct_declarator /* \x y -> unsafeCoerce# (Decl (NoPointer (unsafeCoerce# (x))))*/, CatTag.CAT_Init_declarator /* \x y -> unsafeCoerce# (OnlyDecl (NoPointer (unsafeCoerce# (x))))*/,};second = new CatTag[]{ CatTag.CAT_Direct_declarator /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Declarator /* \x y -> unsafeCoerce# (NoPointer (unsafeCoerce# (x)))*/, CatTag.CAT_Struct_declarator_List /* \x y -> unsafeCoerce# ((:[]) (Decl (NoPointer (unsafeCoerce# (x)))))*/, CatTag.CAT_Init_declarator_List /* \x y -> unsafeCoerce# ((:[]) (OnlyDecl (NoPointer (unsafeCoerce# (x)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_31:
		switch(r2){
			case CAT_Pointer:
			first = new CatTag[]{ CatTag.CAT_Pointer /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ CatTag.CAT_Pointer /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Abstract_declarator /* \x y -> unsafeCoerce# (PointerStart (unsafeCoerce# (x) (unsafeCoerce# (y))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_32:
		switch(r2){
			case TOK_464646:
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Parameter_type /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_33:
		switch(r2){
			case CAT_Parameter_declaration:
			first = new CatTag[]{ CatTag.CAT_Parameter_declarations /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ CatTag.CAT_Parameter_type /* \x y -> unsafeCoerce# (AllSpec (unsafeCoerce# (x) (unsafeCoerce# (y))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_34:
		switch(r2){
			case CAT_Ident_List:
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Ident_List /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_35:
		switch(r2){
			case TOK_CLOS_:
			first = new CatTag[]{ CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (unsafeCoerce# (x)))*/,};second = new CatTag[]{ CatTag.CAT_Initz /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (unsafeCoerce# (x)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_36:
		switch(r2){
			case TOK_CLOS_:
			first = new CatTag[]{ CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (unsafeCoerce# (x)))*/,};second = new CatTag[]{ CatTag.CAT_Initz /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (unsafeCoerce# (x)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_37:
		switch(r2){
			case TOK_44:
			first = new CatTag[]{ CatTag.CAT_36 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_38:
		switch(r2){
			case CAT_Initz:
			first = new CatTag[]{ CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_39:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Abstract_declarator /* \x y -> unsafeCoerce# (Advanced (unsafeCoerce# (x)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_4:
		switch(r2){
			case TOK_59:
			first = new CatTag[]{ CatTag.CAT_Dec /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_External_declaration /* \x y -> unsafeCoerce# (Global (unsafeCoerce# (x)))*/, CatTag.CAT_Program /* \x y -> unsafeCoerce# (Progr ((:[]) (Global (unsafeCoerce# (x)))))*/,};second = new CatTag[]{ CatTag.CAT_Dec_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x)))*/, CatTag.CAT_External_declaration_List /* \x y -> unsafeCoerce# ((:[]) (Global (unsafeCoerce# (x))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_40:
		switch(r2){
			case TOK__List:
			first = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Abstract_declarator /* \x y -> unsafeCoerce# (Advanced (unsafeCoerce# (x)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_41:
		switch(r2){
			case TOK__List:
			first = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Abstract_declarator /* \x y -> unsafeCoerce# (Advanced (unsafeCoerce# (x)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_42:
		switch(r2){
			case TOK__List:
			first = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Abstract_declarator /* \x y -> unsafeCoerce# (Advanced (unsafeCoerce# (x)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_43:
		switch(r2){
			case CAT_Constant_expression:
			first = new CatTag[]{ CatTag.CAT_42 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_44:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Abstract_declarator /* \x y -> unsafeCoerce# (Advanced (unsafeCoerce# (x)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_45:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Abstract_declarator /* \x y -> unsafeCoerce# (Advanced (unsafeCoerce# (x)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_46:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Abstract_declarator /* \x y -> unsafeCoerce# (Advanced (unsafeCoerce# (x)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_47:
		switch(r2){
			case CAT_Parameter_type:
			first = new CatTag[]{ CatTag.CAT_46 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_48:
		switch(r2){
			case CAT_Stm:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (LabelS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/,};second = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (LabelS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (LabelS (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_49:
		switch(r2){
			case CAT_Stm:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (LabelS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/,};second = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (LabelS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (LabelS (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_5:
		switch(r2){
			case CAT_Init_declarator_List:
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Init_declarator_List /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_50:
		switch(r2){
			case TOK_58:
			first = new CatTag[]{ CatTag.CAT_49 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_51:
		switch(r2){
			case CAT_Stm:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (LabelS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/,};second = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (LabelS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (LabelS (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_52:
		switch(r2){
			case TOK_CLOS_:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (CompS (unsafeCoerce# (x)))*/,};second = new CatTag[]{ CatTag.CAT_Compound_stm /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Stm /* \x y -> unsafeCoerce# (CompS (unsafeCoerce# (x)))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (CompS (unsafeCoerce# (x))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_53:
		switch(r2){
			case TOK_CLOS_:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (CompS (unsafeCoerce# (x)))*/,};second = new CatTag[]{ CatTag.CAT_Compound_stm /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Stm /* \x y -> unsafeCoerce# (CompS (unsafeCoerce# (x)))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (CompS (unsafeCoerce# (x))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_54:
		switch(r2){
			case TOK_CLOS_:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (CompS (unsafeCoerce# (x)))*/,};second = new CatTag[]{ CatTag.CAT_Compound_stm /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/, CatTag.CAT_Stm /* \x y -> unsafeCoerce# (CompS (unsafeCoerce# (x)))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (CompS (unsafeCoerce# (x))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_55:
		switch(r2){
			case CAT_Stm_List:
			first = new CatTag[]{ CatTag.CAT_54 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_56:
		switch(r2){
			case CAT_Stm:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (SelS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/,};second = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (SelS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (SelS (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_57:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_56 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_58:
		switch(r2){
			case CAT_Exp:
			first = new CatTag[]{ CatTag.CAT_57 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_59:
		switch(r2){
			case CAT_Stm:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (SelS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/,};second = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (SelS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (SelS (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_6:
		switch(r2){
			case CAT_Initz:
			first = new CatTag[]{ CatTag.CAT_Init_declarator /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ CatTag.CAT_Init_declarator_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_60:
		switch(r2){
			case TOK_else:
			first = new CatTag[]{ CatTag.CAT_59 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_61:
		switch(r2){
			case CAT_Stm:
			first = new CatTag[]{ CatTag.CAT_60 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_62:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_61 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_63:
		switch(r2){
			case CAT_Exp:
			first = new CatTag[]{ CatTag.CAT_62 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_64:
		switch(r2){
			case CAT_Stm:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (SelS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/,};second = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (SelS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (SelS (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_65:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_64 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_66:
		switch(r2){
			case CAT_Exp:
			first = new CatTag[]{ CatTag.CAT_65 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_67:
		switch(r2){
			case CAT_Stm:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (IterS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/,};second = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (IterS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (IterS (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_68:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_67 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_69:
		switch(r2){
			case CAT_Exp:
			first = new CatTag[]{ CatTag.CAT_68 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_7:
		switch(r2){
			case TOK_CLOS_:
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* \x y -> unsafeCoerce# (Type (Tstruct (unsafeCoerce# (x))))*/, CatTag.CAT_Spec_qual /* \x y -> unsafeCoerce# (TypeSpec (Tstruct (unsafeCoerce# (x))))*/, CatTag.CAT_Declaration_specifier_List /* \x y -> unsafeCoerce# ((:[]) (Type (Tstruct (unsafeCoerce# (x)))))*/, CatTag.CAT_Spec_qual_List /* \x y -> unsafeCoerce# ((:[]) (TypeSpec (Tstruct (unsafeCoerce# (x)))))*/, CatTag.CAT_Parameter_declarations /* \x y -> unsafeCoerce# (ParamDec (OnlyType ((:[]) (Type (Tstruct (unsafeCoerce# (x)))))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* \x y -> unsafeCoerce# ((:[]) (Type (Tstruct (unsafeCoerce# (x)))))*/, CatTag.CAT_Spec_qual_List /* \x y -> unsafeCoerce# ((:[]) (TypeSpec (Tstruct (unsafeCoerce# (x)))))*/, CatTag.CAT_Parameter_declaration /* \x y -> unsafeCoerce# (OnlyType ((:[]) (Type (Tstruct (unsafeCoerce# (x))))))*/, CatTag.CAT_Type_name /* \x y -> unsafeCoerce# (PlainType ((:[]) (TypeSpec (Tstruct (unsafeCoerce# (x))))))*/, CatTag.CAT_Parameter_type /* \x y -> unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Type (Tstruct (unsafeCoerce# (x))))))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_70:
		switch(r2){
			case TOK_59:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (IterS (unsafeCoerce# (x)))*/,};second = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (IterS (unsafeCoerce# (x)))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (IterS (unsafeCoerce# (x))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_71:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_70 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_72:
		switch(r2){
			case CAT_Exp:
			first = new CatTag[]{ CatTag.CAT_71 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_73:
		switch(r2){
			case TOK_40:
			first = new CatTag[]{ CatTag.CAT_72 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_74:
		switch(r2){
			case TOK_while:
			first = new CatTag[]{ CatTag.CAT_73 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_75:
		switch(r2){
			case CAT_Stm:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (IterS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/,};second = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (IterS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (IterS (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_76:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_75 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_77:
		switch(r2){
			case CAT_Expression_stm:
			first = new CatTag[]{ CatTag.CAT_76 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_78:
		switch(r2){
			case CAT_Expression_stm:
			first = new CatTag[]{ CatTag.CAT_77 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_79:
		switch(r2){
			case CAT_Stm:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (IterS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/,};second = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (IterS (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (IterS (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_8:
		switch(r2){
			case CAT_Struct_dec_List:
			first = new CatTag[]{ CatTag.CAT_7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_80:
		switch(r2){
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_79 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_81:
		switch(r2){
			case CAT_Exp:
			first = new CatTag[]{ CatTag.CAT_80 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_82:
		switch(r2){
			case CAT_Expression_stm:
			first = new CatTag[]{ CatTag.CAT_81 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_83:
		switch(r2){
			case CAT_Expression_stm:
			first = new CatTag[]{ CatTag.CAT_82 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_84:
		switch(r2){
			case TOK_59:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (JumpS (unsafeCoerce# (x)))*/,};second = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (JumpS (unsafeCoerce# (x)))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (JumpS (unsafeCoerce# (x))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_85:
		switch(r2){
			case TOK_59:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (JumpS (unsafeCoerce# (x)))*/,};second = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (JumpS (unsafeCoerce# (x)))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (JumpS (unsafeCoerce# (x))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_86:
		switch(r2){
			case CAT_Exp2:
			first = new CatTag[]{ CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_87:
		switch(r2){
			case CAT_Exp2:
			first = new CatTag[]{ CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_88:
		switch(r2){
			case CAT_Exp3:
			first = new CatTag[]{ CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_89:
		switch(r2){
			case TOK_58:
			first = new CatTag[]{ CatTag.CAT_88 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_9:
		switch(r2){
			case TOK_OPEN_:
			first = new CatTag[]{ CatTag.CAT_8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_90:
		switch(r2){
			case CAT_Exp:
			first = new CatTag[]{ CatTag.CAT_89 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_91:
		switch(r2){
			case CAT_Exp5:
			first = new CatTag[]{ CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_92:
		switch(r2){
			case CAT_Exp6:
			first = new CatTag[]{ CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_93:
		switch(r2){
			case CAT_Exp7:
			first = new CatTag[]{ CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_94:
		switch(r2){
			case CAT_Exp8:
			first = new CatTag[]{ CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_95:
		switch(r2){
			case CAT_Exp9:
			first = new CatTag[]{ CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_96:
		switch(r2){
			case CAT_Exp10:
			first = new CatTag[]{ CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_97:
		switch(r2){
			case CAT_Exp10:
			first = new CatTag[]{ CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_98:
		switch(r2){
			case CAT_Exp11:
			first = new CatTag[]{ CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_99:
		switch(r2){
			case CAT_Exp11:
			first = new CatTag[]{ CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (unsafeCoerce# (x) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (unsafeCoerce# (x) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Dec:
		switch(r2){
			case CAT_Dec_List:
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Dec_List /* \x y -> unsafeCoerce# ((:) (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Declaration_specifier:
		switch(r2){
			case CAT_Declaration_specifier_List:
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* \x y -> unsafeCoerce# ((:) (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Parameter_declarations /* \x y -> unsafeCoerce# (ParamDec (OnlyType ((:) (unsafeCoerce# (x)) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* \x y -> unsafeCoerce# ((:) (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Parameter_declaration /* \x y -> unsafeCoerce# (OnlyType ((:) (unsafeCoerce# (x)) (unsafeCoerce# (y))))*/, CatTag.CAT_Parameter_type /* \x y -> unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:) (unsafeCoerce# (x)) (unsafeCoerce# (y))))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Declarator:
		switch(r2){
			case CAT_Compound_stm:
			first = new CatTag[]{ CatTag.CAT_External_declaration /* \x y -> unsafeCoerce# (Afunc (NewFuncInt (unsafeCoerce# (x)) (unsafeCoerce# (y))))*/, CatTag.CAT_Program /* \x y -> unsafeCoerce# (Progr ((:[]) (Afunc (NewFuncInt (unsafeCoerce# (x)) (unsafeCoerce# (y))))))*/,};second = new CatTag[]{ CatTag.CAT_External_declaration_List /* \x y -> unsafeCoerce# ((:[]) (Afunc (NewFuncInt (unsafeCoerce# (x)) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			case CAT_Dec_List:
			first = new CatTag[]{ CatTag.CAT_3 /* \x y -> unsafeCoerce# (OldFuncInt (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_58:
			first = new CatTag[]{ CatTag.CAT_14 /* \x y -> unsafeCoerce# (DecField (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_61:
			first = new CatTag[]{ CatTag.CAT_6 /* \x y -> unsafeCoerce# (InitDecl (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Dir_abs_dec:
		switch(r2){
			case TOK_40:
			first = new CatTag[]{ CatTag.CAT_45 /* \x y -> unsafeCoerce# (OldFuncExpr (unsafeCoerce# (x)))*/, CatTag.CAT_47 /* \x y -> unsafeCoerce# (NewFuncExpr (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_:
			first = new CatTag[]{ CatTag.CAT_41 /* \x y -> unsafeCoerce# (UnInitiated (unsafeCoerce# (x)))*/, CatTag.CAT_43 /* \x y -> unsafeCoerce# (Initiated (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Direct_declarator:
		switch(r2){
			case TOK_40:
			first = new CatTag[]{ CatTag.CAT_27 /* \x y -> unsafeCoerce# (NewFuncDec (unsafeCoerce# (x)))*/, CatTag.CAT_29 /* \x y -> unsafeCoerce# (OldFuncDef (unsafeCoerce# (x)))*/, CatTag.CAT_30 /* \x y -> unsafeCoerce# (OldFuncDec (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_:
			first = new CatTag[]{ CatTag.CAT_24 /* \x y -> unsafeCoerce# (InnitArray (unsafeCoerce# (x)))*/, CatTag.CAT_25 /* \x y -> unsafeCoerce# (Incomplete (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Enumerator:
		switch(r2){
			case TOK_44:
			first = new CatTag[]{ CatTag.CAT_20 /* \x y -> unsafeCoerce# ((:) (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Exp:
		switch(r2){
			case TOK_44:
			first = new CatTag[]{ CatTag.CAT_86 /* \x y -> unsafeCoerce# (Ecomma (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_59:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (ExprS (SexprTwo (unsafeCoerce# (x))))*/,};second = new CatTag[]{ CatTag.CAT_Expression_stm /* \x y -> unsafeCoerce# (SexprTwo (unsafeCoerce# (x)))*/, CatTag.CAT_Stm /* \x y -> unsafeCoerce# (ExprS (SexprTwo (unsafeCoerce# (x))))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (ExprS (SexprTwo (unsafeCoerce# (x)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Exp10:
		switch(r2){
			case TOK_60:
			first = new CatTag[]{ CatTag.CAT_98 /* \x y -> unsafeCoerce# (Elthen (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_6061:
			first = new CatTag[]{ CatTag.CAT_100 /* \x y -> unsafeCoerce# (Ele (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_62:
			first = new CatTag[]{ CatTag.CAT_99 /* \x y -> unsafeCoerce# (Egrthen (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_6261:
			first = new CatTag[]{ CatTag.CAT_101 /* \x y -> unsafeCoerce# (Ege (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Exp11:
		switch(r2){
			case TOK_6060:
			first = new CatTag[]{ CatTag.CAT_102 /* \x y -> unsafeCoerce# (Eleft (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_6262:
			first = new CatTag[]{ CatTag.CAT_103 /* \x y -> unsafeCoerce# (Eright (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Exp12:
		switch(r2){
			case TOK_43:
			first = new CatTag[]{ CatTag.CAT_104 /* \x y -> unsafeCoerce# (Eplus (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_45:
			first = new CatTag[]{ CatTag.CAT_105 /* \x y -> unsafeCoerce# (Eminus (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Exp13:
		switch(r2){
			case TOK_37:
			first = new CatTag[]{ CatTag.CAT_108 /* \x y -> unsafeCoerce# (Emod (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_42:
			first = new CatTag[]{ CatTag.CAT_106 /* \x y -> unsafeCoerce# (Etimes (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_47:
			first = new CatTag[]{ CatTag.CAT_107 /* \x y -> unsafeCoerce# (Ediv (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Exp15:
		switch(r2){
			case CAT_Assignment_op:
			first = new CatTag[]{ CatTag.CAT_87 /* \x y -> unsafeCoerce# (Eassign (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Exp16:
		switch(r2){
			case TOK_40:
			first = new CatTag[]{ CatTag.CAT_115 /* \x y -> unsafeCoerce# (Efunk (unsafeCoerce# (x)))*/, CatTag.CAT_117 /* \x y -> unsafeCoerce# (Efunkpar (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_4343:
			first = new CatTag[]{ CatTag.CAT_Exp16 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (Epostinc (unsafeCoerce# (x)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp14 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (Epostinc (unsafeCoerce# (x)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (Epostinc (unsafeCoerce# (x))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (Epostinc (unsafeCoerce# (x))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (Epostinc (unsafeCoerce# (x))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (Epostinc (unsafeCoerce# (x)))))*/,};
			return new Pair (first ,second);
			case TOK_4545:
			first = new CatTag[]{ CatTag.CAT_Exp16 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (Epostdec (unsafeCoerce# (x)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp14 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (Epostdec (unsafeCoerce# (x)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (Epostdec (unsafeCoerce# (x))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (Epostdec (unsafeCoerce# (x))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (Epostdec (unsafeCoerce# (x))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (Epostdec (unsafeCoerce# (x)))))*/,};
			return new Pair (first ,second);
			case TOK_4562:
			first = new CatTag[]{ CatTag.CAT_119 /* \x y -> unsafeCoerce# (Epoint (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_46:
			first = new CatTag[]{ CatTag.CAT_118 /* \x y -> unsafeCoerce# (Eselect (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_:
			first = new CatTag[]{ CatTag.CAT_114 /* \x y -> unsafeCoerce# (Earray (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Exp2:
		switch(r2){
			case TOK_44:
			first = new CatTag[]{ CatTag.CAT_121 /* \x y -> unsafeCoerce# ((:) (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Exp4:
		switch(r2){
			case TOK_63:
			first = new CatTag[]{ CatTag.CAT_90 /* \x y -> unsafeCoerce# (Econdition (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_124124:
			first = new CatTag[]{ CatTag.CAT_91 /* \x y -> unsafeCoerce# (Elor (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Exp5:
		switch(r2){
			case TOK_3838:
			first = new CatTag[]{ CatTag.CAT_92 /* \x y -> unsafeCoerce# (Eland (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Exp6:
		switch(r2){
			case TOK_124:
			first = new CatTag[]{ CatTag.CAT_93 /* \x y -> unsafeCoerce# (Ebitor (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Exp7:
		switch(r2){
			case TOK_94:
			first = new CatTag[]{ CatTag.CAT_94 /* \x y -> unsafeCoerce# (Ebitexor (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Exp8:
		switch(r2){
			case TOK_38:
			first = new CatTag[]{ CatTag.CAT_95 /* \x y -> unsafeCoerce# (Ebitand (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Exp9:
		switch(r2){
			case TOK_3361:
			first = new CatTag[]{ CatTag.CAT_97 /* \x y -> unsafeCoerce# (Eneq (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_6161:
			first = new CatTag[]{ CatTag.CAT_96 /* \x y -> unsafeCoerce# (Eeq (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_External_declaration:
		switch(r2){
			case CAT_External_declaration_List:
			first = new CatTag[]{ CatTag.CAT_Program /* \x y -> unsafeCoerce# (Progr ((:) (unsafeCoerce# (x)) (unsafeCoerce# (y))))*/,};second = new CatTag[]{ CatTag.CAT_External_declaration_List /* \x y -> unsafeCoerce# ((:) (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Ident:
		switch(r2){
			case TOK_44:
			first = new CatTag[]{ CatTag.CAT_34 /* \x y -> unsafeCoerce# ((:) (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_58:
			first = new CatTag[]{ CatTag.CAT_48 /* \x y -> unsafeCoerce# (SlabelOne (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_61:
			first = new CatTag[]{ CatTag.CAT_21 /* \x y -> unsafeCoerce# (EnumInit (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Init_declarator:
		switch(r2){
			case TOK_44:
			first = new CatTag[]{ CatTag.CAT_5 /* \x y -> unsafeCoerce# ((:) (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Initializers:
		switch(r2){
			case TOK_44:
			first = new CatTag[]{ CatTag.CAT_38 /* \x y -> unsafeCoerce# (MoreInit (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Parameter_declarations:
		switch(r2){
			case TOK_44:
			first = new CatTag[]{ CatTag.CAT_32 /* \x y -> unsafeCoerce# (More (unsafeCoerce# (x)))*/, CatTag.CAT_33 /* \x y -> unsafeCoerce# (MoreParamDec (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Pointer:
		switch(r2){
			case CAT_Dir_abs_dec:
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Abstract_declarator /* \x y -> unsafeCoerce# (PointAdvanced (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/,};
			return new Pair (first ,second);
			case CAT_Direct_declarator:
			first = new CatTag[]{ CatTag.CAT_Declarator /* \x y -> unsafeCoerce# (BeginPointer (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Struct_declarator /* \x y -> unsafeCoerce# (Decl (BeginPointer (unsafeCoerce# (x)) (unsafeCoerce# (y))))*/, CatTag.CAT_Init_declarator /* \x y -> unsafeCoerce# (OnlyDecl (BeginPointer (unsafeCoerce# (x)) (unsafeCoerce# (y))))*/,};second = new CatTag[]{ CatTag.CAT_Declarator /* \x y -> unsafeCoerce# (BeginPointer (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Struct_declarator_List /* \x y -> unsafeCoerce# ((:[]) (Decl (BeginPointer (unsafeCoerce# (x)) (unsafeCoerce# (y)))))*/, CatTag.CAT_Init_declarator_List /* \x y -> unsafeCoerce# ((:[]) (OnlyDecl (BeginPointer (unsafeCoerce# (x)) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Spec_qual:
		switch(r2){
			case CAT_Spec_qual_List:
			first = new CatTag[]{ CatTag.CAT_Spec_qual_List /* \x y -> unsafeCoerce# ((:) (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ CatTag.CAT_Spec_qual_List /* \x y -> unsafeCoerce# ((:) (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Type_name /* \x y -> unsafeCoerce# (PlainType ((:) (unsafeCoerce# (x)) (unsafeCoerce# (y))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Stm:
		switch(r2){
			case CAT_Stm_List:
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:) (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Struct_dec:
		switch(r2){
			case CAT_Struct_dec_List:
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Struct_dec_List /* \x y -> unsafeCoerce# ((:) (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Struct_declarator:
		switch(r2){
			case TOK_44:
			first = new CatTag[]{ CatTag.CAT_13 /* \x y -> unsafeCoerce# ((:) (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Struct_or_union:
		switch(r2){
			case CAT_Ident:
			first = new CatTag[]{ CatTag.CAT_9 /* \x y -> unsafeCoerce# (Tag (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Declaration_specifier /* \x y -> unsafeCoerce# (Type (Tstruct (TagType (unsafeCoerce# (x)) (unsafeCoerce# (y)))))*/, CatTag.CAT_Spec_qual /* \x y -> unsafeCoerce# (TypeSpec (Tstruct (TagType (unsafeCoerce# (x)) (unsafeCoerce# (y)))))*/, CatTag.CAT_Declaration_specifier_List /* \x y -> unsafeCoerce# ((:[]) (Type (Tstruct (TagType (unsafeCoerce# (x)) (unsafeCoerce# (y))))))*/, CatTag.CAT_Spec_qual_List /* \x y -> unsafeCoerce# ((:[]) (TypeSpec (Tstruct (TagType (unsafeCoerce# (x)) (unsafeCoerce# (y))))))*/, CatTag.CAT_Parameter_declarations /* \x y -> unsafeCoerce# (ParamDec (OnlyType ((:[]) (Type (Tstruct (TagType (unsafeCoerce# (x)) (unsafeCoerce# (y))))))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* \x y -> unsafeCoerce# ((:[]) (Type (Tstruct (TagType (unsafeCoerce# (x)) (unsafeCoerce# (y))))))*/, CatTag.CAT_Spec_qual_List /* \x y -> unsafeCoerce# ((:[]) (TypeSpec (Tstruct (TagType (unsafeCoerce# (x)) (unsafeCoerce# (y))))))*/, CatTag.CAT_Parameter_declaration /* \x y -> unsafeCoerce# (OnlyType ((:[]) (Type (Tstruct (TagType (unsafeCoerce# (x)) (unsafeCoerce# (y)))))))*/, CatTag.CAT_Type_name /* \x y -> unsafeCoerce# (PlainType ((:[]) (TypeSpec (Tstruct (TagType (unsafeCoerce# (x)) (unsafeCoerce# (y)))))))*/, CatTag.CAT_Parameter_type /* \x y -> unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Type (Tstruct (TagType (unsafeCoerce# (x)) (unsafeCoerce# (y)))))))))*/,};
			return new Pair (first ,second);
			case TOK_OPEN_:
			first = new CatTag[]{ CatTag.CAT_11 /* \x y -> unsafeCoerce# (Unique (unsafeCoerce# (x)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Type_qualifier:
		switch(r2){
			case CAT_Type_qualifier_List:
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Type_qualifier_List /* \x y -> unsafeCoerce# ((:) (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Unary_operator:
		switch(r2){
			case CAT_Exp14:
			first = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp14 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (Epreop (unsafeCoerce# (x)) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Declaration_specifier_List:
		switch(r2){
			case CAT_Abstract_declarator:
			first = new CatTag[]{ CatTag.CAT_Parameter_declarations /* \x y -> unsafeCoerce# (ParamDec (Abstract (unsafeCoerce# (x)) (unsafeCoerce# (y))))*/,};second = new CatTag[]{ CatTag.CAT_Parameter_declaration /* \x y -> unsafeCoerce# (Abstract (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Parameter_type /* \x y -> unsafeCoerce# (AllSpec (ParamDec (Abstract (unsafeCoerce# (x)) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			case CAT_Declarator:
			first = new CatTag[]{ CatTag.CAT_1 /* \x y -> unsafeCoerce# (OldFunc (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_2 /* \x y -> unsafeCoerce# (NewFunc (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Parameter_declarations /* \x y -> unsafeCoerce# (ParamDec (TypeAndParam (unsafeCoerce# (x)) (unsafeCoerce# (y))))*/,};second = new CatTag[]{ CatTag.CAT_Parameter_declaration /* \x y -> unsafeCoerce# (TypeAndParam (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/, CatTag.CAT_Parameter_type /* \x y -> unsafeCoerce# (AllSpec (ParamDec (TypeAndParam (unsafeCoerce# (x)) (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			case CAT_Init_declarator_List:
			first = new CatTag[]{ CatTag.CAT_4 /* \x y -> unsafeCoerce# (Declarators (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_59:
			first = new CatTag[]{ CatTag.CAT_Dec /* \x y -> unsafeCoerce# (NoDeclarator (unsafeCoerce# (x)))*/, CatTag.CAT_External_declaration /* \x y -> unsafeCoerce# (Global (NoDeclarator (unsafeCoerce# (x))))*/, CatTag.CAT_Program /* \x y -> unsafeCoerce# (Progr ((:[]) (Global (NoDeclarator (unsafeCoerce# (x))))))*/,};second = new CatTag[]{ CatTag.CAT_Dec_List /* \x y -> unsafeCoerce# ((:[]) (NoDeclarator (unsafeCoerce# (x))))*/, CatTag.CAT_External_declaration_List /* \x y -> unsafeCoerce# ((:[]) (Global (NoDeclarator (unsafeCoerce# (x)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case CAT_Spec_qual_List:
		switch(r2){
			case CAT_Abstract_declarator:
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Type_name /* \x y -> unsafeCoerce# (ExtendedType (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/,};
			return new Pair (first ,second);
			case CAT_Struct_declarator_List:
			first = new CatTag[]{ CatTag.CAT_12 /* \x y -> unsafeCoerce# (Structen (unsafeCoerce# (x)) (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_40:
		switch(r2){
			case CAT_Abstract_declarator:
			first = new CatTag[]{ CatTag.CAT_39 /* \x y -> unsafeCoerce# (WithinParentes (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case CAT_Declarator:
			first = new CatTag[]{ CatTag.CAT_22 /* \x y -> unsafeCoerce# (ParenDecl (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case CAT_Exp:
			first = new CatTag[]{ CatTag.CAT_120 /* \x y -> unsafeCoerce# (unsafeCoerce# (y))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case CAT_Parameter_type:
			first = new CatTag[]{ CatTag.CAT_44 /* \x y -> unsafeCoerce# (NewFunction (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case CAT_Type_name:
			first = new CatTag[]{ CatTag.CAT_110 /* \x y -> unsafeCoerce# (Etypeconv (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_41:
			first = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (OldFunction)*/,};second = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (OldFunction)*/, CatTag.CAT_Abstract_declarator /* \x y -> unsafeCoerce# (Advanced (OldFunction))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_42:
		switch(r2){
			case CAT_Pointer:
			first = new CatTag[]{ CatTag.CAT_Pointer /* \x y -> unsafeCoerce# (PointPoint (unsafeCoerce# (y)))*/,};second = new CatTag[]{ CatTag.CAT_Pointer /* \x y -> unsafeCoerce# (PointPoint (unsafeCoerce# (y)))*/, CatTag.CAT_Abstract_declarator /* \x y -> unsafeCoerce# (PointerStart (PointPoint (unsafeCoerce# (y))))*/,};
			return new Pair (first ,second);
			case CAT_Type_qualifier_List:
			first = new CatTag[]{ CatTag.CAT_Pointer /* \x y -> unsafeCoerce# (PointQual (unsafeCoerce# (y)))*/, CatTag.CAT_31 /* \x y -> unsafeCoerce# (PointQualPoint (unsafeCoerce# (y)))*/,};second = new CatTag[]{ CatTag.CAT_Pointer /* \x y -> unsafeCoerce# (PointQual (unsafeCoerce# (y)))*/, CatTag.CAT_Abstract_declarator /* \x y -> unsafeCoerce# (PointerStart (PointQual (unsafeCoerce# (y))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_4343:
		switch(r2){
			case CAT_Exp15:
			first = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (Epreinc (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp14 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (Epreinc (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (Epreinc (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (Epreinc (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (Epreinc (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (Epreinc (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_4545:
		switch(r2){
			case CAT_Exp15:
			first = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (Epredec (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp14 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (Epredec (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (Epredec (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (Epredec (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (Epredec (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (Epredec (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_58:
		switch(r2){
			case CAT_Constant_expression:
			first = new CatTag[]{ CatTag.CAT_Struct_declarator /* \x y -> unsafeCoerce# (Field (unsafeCoerce# (y)))*/,};second = new CatTag[]{ CatTag.CAT_Struct_declarator_List /* \x y -> unsafeCoerce# ((:[]) (Field (unsafeCoerce# (y))))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_:
		switch(r2){
			case CAT_Constant_expression:
			first = new CatTag[]{ CatTag.CAT_40 /* \x y -> unsafeCoerce# (InitiatedArray (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK__List:
			first = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (Array)*/,};second = new CatTag[]{ CatTag.CAT_Dir_abs_dec /* \x y -> unsafeCoerce# (Array)*/, CatTag.CAT_Abstract_declarator /* \x y -> unsafeCoerce# (Advanced (Array))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_break:
		switch(r2){
			case TOK_59:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (JumpS (SjumpThree))*/,};second = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (JumpS (SjumpThree))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (JumpS (SjumpThree)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_case:
		switch(r2){
			case CAT_Constant_expression:
			first = new CatTag[]{ CatTag.CAT_50 /* \x y -> unsafeCoerce# (SlabelTwo (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_continue:
		switch(r2){
			case TOK_59:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (JumpS (SjumpTwo))*/,};second = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (JumpS (SjumpTwo))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (JumpS (SjumpTwo)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_default:
		switch(r2){
			case TOK_58:
			first = new CatTag[]{ CatTag.CAT_51 /* \x y -> unsafeCoerce# (SlabelThree)*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_do:
		switch(r2){
			case CAT_Stm:
			first = new CatTag[]{ CatTag.CAT_74 /* \x y -> unsafeCoerce# (SiterTwo (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_enum:
		switch(r2){
			case CAT_Ident:
			first = new CatTag[]{ CatTag.CAT_19 /* \x y -> unsafeCoerce# (EnumName (unsafeCoerce# (y)))*/, CatTag.CAT_Declaration_specifier /* \x y -> unsafeCoerce# (Type (Tenum (EnumVar (unsafeCoerce# (y)))))*/, CatTag.CAT_Spec_qual /* \x y -> unsafeCoerce# (TypeSpec (Tenum (EnumVar (unsafeCoerce# (y)))))*/, CatTag.CAT_Declaration_specifier_List /* \x y -> unsafeCoerce# ((:[]) (Type (Tenum (EnumVar (unsafeCoerce# (y))))))*/, CatTag.CAT_Spec_qual_List /* \x y -> unsafeCoerce# ((:[]) (TypeSpec (Tenum (EnumVar (unsafeCoerce# (y))))))*/, CatTag.CAT_Parameter_declarations /* \x y -> unsafeCoerce# (ParamDec (OnlyType ((:[]) (Type (Tenum (EnumVar (unsafeCoerce# (y))))))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* \x y -> unsafeCoerce# ((:[]) (Type (Tenum (EnumVar (unsafeCoerce# (y))))))*/, CatTag.CAT_Spec_qual_List /* \x y -> unsafeCoerce# ((:[]) (TypeSpec (Tenum (EnumVar (unsafeCoerce# (y))))))*/, CatTag.CAT_Parameter_declaration /* \x y -> unsafeCoerce# (OnlyType ((:[]) (Type (Tenum (EnumVar (unsafeCoerce# (y)))))))*/, CatTag.CAT_Type_name /* \x y -> unsafeCoerce# (PlainType ((:[]) (TypeSpec (Tenum (EnumVar (unsafeCoerce# (y)))))))*/, CatTag.CAT_Parameter_type /* \x y -> unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Type (Tenum (EnumVar (unsafeCoerce# (y)))))))))*/,};
			return new Pair (first ,second);
			case TOK_OPEN_:
			first = new CatTag[]{ CatTag.CAT_16 /* \x y -> unsafeCoerce# (EnumDec)*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_for:
		switch(r2){
			case TOK_40:
			first = new CatTag[]{ CatTag.CAT_78 /* \x y -> unsafeCoerce# (SiterThree)*/, CatTag.CAT_83 /* \x y -> unsafeCoerce# (SiterFour)*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_goto:
		switch(r2){
			case CAT_Ident:
			first = new CatTag[]{ CatTag.CAT_84 /* \x y -> unsafeCoerce# (SjumpOne (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_if:
		switch(r2){
			case TOK_40:
			first = new CatTag[]{ CatTag.CAT_58 /* \x y -> unsafeCoerce# (SselOne)*/, CatTag.CAT_63 /* \x y -> unsafeCoerce# (SselTwo)*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_return:
		switch(r2){
			case CAT_Exp:
			first = new CatTag[]{ CatTag.CAT_85 /* \x y -> unsafeCoerce# (SjumpFive (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_59:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (JumpS (SjumpFour))*/,};second = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (JumpS (SjumpFour))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (JumpS (SjumpFour)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_sizeof:
		switch(r2){
			case CAT_Exp15:
			first = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp4 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (Ebytesexpr (unsafeCoerce# (y)))))*/,};second = new CatTag[]{ CatTag.CAT_Exp15 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp14 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp13 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp12 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp11 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp10 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp9 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp8 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp7 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp6 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp5 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp3 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2 /* \x y -> unsafeCoerce# (Ebytesexpr (unsafeCoerce# (y)))*/, CatTag.CAT_Exp2_List /* \x y -> unsafeCoerce# ((:[]) (Ebytesexpr (unsafeCoerce# (y))))*/, CatTag.CAT_Constant_expression /* \x y -> unsafeCoerce# (Especial (Ebytesexpr (unsafeCoerce# (y))))*/, CatTag.CAT_Initz /* \x y -> unsafeCoerce# (InitExpr (Ebytesexpr (unsafeCoerce# (y))))*/, CatTag.CAT_Initializers /* \x y -> unsafeCoerce# (AnInit (InitExpr (Ebytesexpr (unsafeCoerce# (y)))))*/,};
			return new Pair (first ,second);
			case TOK_40:
			first = new CatTag[]{ CatTag.CAT_112 /* \x y -> unsafeCoerce# (Ebytestype)*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_switch:
		switch(r2){
			case TOK_40:
			first = new CatTag[]{ CatTag.CAT_66 /* \x y -> unsafeCoerce# (SselThree)*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_while:
		switch(r2){
			case TOK_40:
			first = new CatTag[]{ CatTag.CAT_69 /* \x y -> unsafeCoerce# (SiterOne)*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	case TOK_OPEN_:
		switch(r2){
			case CAT_Initializers:
			first = new CatTag[]{ CatTag.CAT_35 /* \x y -> unsafeCoerce# (InitListOne (unsafeCoerce# (y)))*/, CatTag.CAT_37 /* \x y -> unsafeCoerce# (InitListTwo (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case CAT_Dec_List:
			first = new CatTag[]{ CatTag.CAT_53 /* \x y -> unsafeCoerce# (ScompThree (unsafeCoerce# (y)))*/, CatTag.CAT_55 /* \x y -> unsafeCoerce# (ScompFour (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case CAT_Stm_List:
			first = new CatTag[]{ CatTag.CAT_52 /* \x y -> unsafeCoerce# (ScompTwo (unsafeCoerce# (y)))*/,};second = new CatTag[]{ };
			return new Pair (first ,second);
			case TOK_CLOS_:
			first = new CatTag[]{ CatTag.CAT_Stm /* \x y -> unsafeCoerce# (CompS (ScompOne))*/,};second = new CatTag[]{ CatTag.CAT_Compound_stm /* \x y -> unsafeCoerce# (ScompOne)*/, CatTag.CAT_Stm /* \x y -> unsafeCoerce# (CompS (ScompOne))*/, CatTag.CAT_Stm_List /* \x y -> unsafeCoerce# ((:[]) (CompS (ScompOne)))*/,};
			return new Pair (first ,second);
			default: return new Pair(new CatTag[]{}, new CatTag[]{});
		}
	default: return null;
	}
}
public Pair tokenToCats (boolean p, Symbol s){ 
switch (s.sym){ 
 // !
case 1:
 
			first = new CatTag[]{ CatTag.CAT_Unary_operator /* unsafeCoerce# (Logicalneg)*/,};second = new CatTag[]{ };
return new Pair(first, second);
 // !=
case 2:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_3361 /* "error"cannot access value of token: !=\""*/,};
return new Pair(first, second);
 // %
case 3:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_37 /* "error"cannot access value of token: %\""*/,};
return new Pair(first, second);
 // %=
case 4:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Assignment_op /* unsafeCoerce# (AssignMod)*/,};
return new Pair(first, second);
 // &
case 5:
 
			first = new CatTag[]{ CatTag.CAT_Unary_operator /* unsafeCoerce# (Address)*/,};second = new CatTag[]{ CatTag.TOK_38 /* "error"cannot access value of token: &\""*/,};
return new Pair(first, second);
 // &&
case 6:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_3838 /* "error"cannot access value of token: &&\""*/,};
return new Pair(first, second);
 // &=
case 7:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Assignment_op /* unsafeCoerce# (AssignAnd)*/,};
return new Pair(first, second);
 // (
case 8:
 
			first = new CatTag[]{ CatTag.TOK_40 /* "error"cannot access value of token: (\""*/,};second = new CatTag[]{ CatTag.TOK_40 /* "error"cannot access value of token: (\""*/,};
return new Pair(first, second);
 // )
case 9:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_41 /* "error"cannot access value of token: )\""*/,};
return new Pair(first, second);
 // *
case 10:
 
			first = new CatTag[]{ CatTag.TOK_42 /* "error"cannot access value of token: *\""*/, CatTag.CAT_Unary_operator /* unsafeCoerce# (Indirection)*/, CatTag.CAT_Pointer /* unsafeCoerce# (Point)*/,};second = new CatTag[]{ CatTag.TOK_42 /* "error"cannot access value of token: *\""*/, CatTag.CAT_Pointer /* unsafeCoerce# (Point)*/, CatTag.CAT_Abstract_declarator /* unsafeCoerce# (PointerStart (Point))*/,};
return new Pair(first, second);
 // *=
case 11:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Assignment_op /* unsafeCoerce# (AssignMul)*/,};
return new Pair(first, second);
 // +
case 12:
 
			first = new CatTag[]{ CatTag.CAT_Unary_operator /* unsafeCoerce# (Plus)*/,};second = new CatTag[]{ CatTag.TOK_43 /* "error"cannot access value of token: +\""*/,};
return new Pair(first, second);
 // ++
case 13:
 
			first = new CatTag[]{ CatTag.TOK_4343 /* "error"cannot access value of token: ++\""*/,};second = new CatTag[]{ CatTag.TOK_4343 /* "error"cannot access value of token: ++\""*/,};
return new Pair(first, second);
 // +=
case 14:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Assignment_op /* unsafeCoerce# (AssignAdd)*/,};
return new Pair(first, second);
 // ,
case 15:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_44 /* "error"cannot access value of token: ,\""*/,};
return new Pair(first, second);
 // -
case 16:
 
			first = new CatTag[]{ CatTag.CAT_Unary_operator /* unsafeCoerce# (Negative)*/,};second = new CatTag[]{ CatTag.TOK_45 /* "error"cannot access value of token: -\""*/,};
return new Pair(first, second);
 // --
case 17:
 
			first = new CatTag[]{ CatTag.TOK_4545 /* "error"cannot access value of token: --\""*/,};second = new CatTag[]{ CatTag.TOK_4545 /* "error"cannot access value of token: --\""*/,};
return new Pair(first, second);
 // -=
case 18:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Assignment_op /* unsafeCoerce# (AssignSub)*/,};
return new Pair(first, second);
 // ->
case 19:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_4562 /* "error"cannot access value of token: ->\""*/,};
return new Pair(first, second);
 // .
case 20:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_46 /* "error"cannot access value of token: .\""*/,};
return new Pair(first, second);
 // ...
case 21:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_464646 /* "error"cannot access value of token: ...\""*/,};
return new Pair(first, second);
 // /
case 22:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_47 /* "error"cannot access value of token: /\""*/,};
return new Pair(first, second);
 // /=
case 23:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Assignment_op /* unsafeCoerce# (AssignDiv)*/,};
return new Pair(first, second);
 // :
case 24:
 
			first = new CatTag[]{ CatTag.TOK_58 /* "error"cannot access value of token: :\""*/,};second = new CatTag[]{ CatTag.TOK_58 /* "error"cannot access value of token: :\""*/,};
return new Pair(first, second);
 // ;
case 25:
 
			first = new CatTag[]{ CatTag.CAT_Stm /* unsafeCoerce# (ExprS (SexprOne))*/,};second = new CatTag[]{ CatTag.TOK_59 /* "error"cannot access value of token: ;\""*/, CatTag.CAT_Expression_stm /* unsafeCoerce# (SexprOne)*/, CatTag.CAT_Stm /* unsafeCoerce# (ExprS (SexprOne))*/, CatTag.CAT_Stm_List /* unsafeCoerce# ((:[]) (ExprS (SexprOne)))*/,};
return new Pair(first, second);
 // <
case 26:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_60 /* "error"cannot access value of token: <\""*/,};
return new Pair(first, second);
 // <<
case 27:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_6060 /* "error"cannot access value of token: <<\""*/,};
return new Pair(first, second);
 // <<=
case 28:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Assignment_op /* unsafeCoerce# (AssignLeft)*/,};
return new Pair(first, second);
 // <=
case 29:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_6061 /* "error"cannot access value of token: <=\""*/,};
return new Pair(first, second);
 // =
case 30:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_61 /* "error"cannot access value of token: =\""*/, CatTag.CAT_Assignment_op /* unsafeCoerce# (Assign)*/,};
return new Pair(first, second);
 // ==
case 31:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_6161 /* "error"cannot access value of token: ==\""*/,};
return new Pair(first, second);
 // >
case 32:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_62 /* "error"cannot access value of token: >\""*/,};
return new Pair(first, second);
 // >=
case 33:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_6261 /* "error"cannot access value of token: >=\""*/,};
return new Pair(first, second);
 // >>
case 34:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_6262 /* "error"cannot access value of token: >>\""*/,};
return new Pair(first, second);
 // >>=
case 35:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Assignment_op /* unsafeCoerce# (AssignRight)*/,};
return new Pair(first, second);
 // ?
case 36:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_63 /* "error"cannot access value of token: ?\""*/,};
return new Pair(first, second);
 // Typedef_name
case 37:
 
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* unsafeCoerce# (Type (Tname))*/, CatTag.CAT_Spec_qual /* unsafeCoerce# (TypeSpec (Tname))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tname)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tname)))*/, CatTag.CAT_Parameter_declarations /* unsafeCoerce# (ParamDec (OnlyType ((:[]) (Type (Tname)))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tname)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tname)))*/, CatTag.CAT_Parameter_declaration /* unsafeCoerce# (OnlyType ((:[]) (Type (Tname))))*/, CatTag.CAT_Type_name /* unsafeCoerce# (PlainType ((:[]) (TypeSpec (Tname))))*/, CatTag.CAT_Parameter_type /* unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Type (Tname))))))*/,};
return new Pair(first, second);
 // [
case 38:
 
			first = new CatTag[]{ CatTag.TOK_ /* "error"cannot access value of token: [\""*/,};second = new CatTag[]{ CatTag.TOK_ /* "error"cannot access value of token: [\""*/,};
return new Pair(first, second);
 // ]
case 39:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK__List /* "error"cannot access value of token: ]\""*/,};
return new Pair(first, second);
 // ^
case 40:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_94 /* "error"cannot access value of token: ^\""*/,};
return new Pair(first, second);
 // ^=
case 41:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Assignment_op /* unsafeCoerce# (AssignXor)*/,};
return new Pair(first, second);
 // auto
case 42:
 
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* unsafeCoerce# (Storage (LocalBlock))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Storage (LocalBlock)))*/, CatTag.CAT_Parameter_declarations /* unsafeCoerce# (ParamDec (OnlyType ((:[]) (Storage (LocalBlock)))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Storage (LocalBlock)))*/, CatTag.CAT_Parameter_declaration /* unsafeCoerce# (OnlyType ((:[]) (Storage (LocalBlock))))*/, CatTag.CAT_Parameter_type /* unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Storage (LocalBlock))))))*/,};
return new Pair(first, second);
 // break
case 43:
 
			first = new CatTag[]{ CatTag.TOK_break /* "error"cannot access value of token: break\""*/,};second = new CatTag[]{ };
return new Pair(first, second);
 // case
case 44:
 
			first = new CatTag[]{ CatTag.TOK_case /* "error"cannot access value of token: case\""*/,};second = new CatTag[]{ };
return new Pair(first, second);
 // char
case 45:
 
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* unsafeCoerce# (Type (Tchar))*/, CatTag.CAT_Spec_qual /* unsafeCoerce# (TypeSpec (Tchar))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tchar)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tchar)))*/, CatTag.CAT_Parameter_declarations /* unsafeCoerce# (ParamDec (OnlyType ((:[]) (Type (Tchar)))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tchar)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tchar)))*/, CatTag.CAT_Parameter_declaration /* unsafeCoerce# (OnlyType ((:[]) (Type (Tchar))))*/, CatTag.CAT_Type_name /* unsafeCoerce# (PlainType ((:[]) (TypeSpec (Tchar))))*/, CatTag.CAT_Parameter_type /* unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Type (Tchar))))))*/,};
return new Pair(first, second);
 // const
case 46:
 
			first = new CatTag[]{ CatTag.CAT_Type_qualifier /* unsafeCoerce# (Const)*/, CatTag.CAT_Spec_qual /* unsafeCoerce# (QualSpec (Const))*/, CatTag.CAT_Declaration_specifier /* unsafeCoerce# (SpecProp (Const))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (QualSpec (Const)))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (SpecProp (Const)))*/, CatTag.CAT_Parameter_declarations /* unsafeCoerce# (ParamDec (OnlyType ((:[]) (SpecProp (Const)))))*/,};second = new CatTag[]{ CatTag.CAT_Type_qualifier_List /* unsafeCoerce# ((:[]) (Const))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (QualSpec (Const)))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (SpecProp (Const)))*/, CatTag.CAT_Parameter_declaration /* unsafeCoerce# (OnlyType ((:[]) (SpecProp (Const))))*/, CatTag.CAT_Type_name /* unsafeCoerce# (PlainType ((:[]) (QualSpec (Const))))*/, CatTag.CAT_Parameter_type /* unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (SpecProp (Const))))))*/,};
return new Pair(first, second);
 // continue
case 47:
 
			first = new CatTag[]{ CatTag.TOK_continue /* "error"cannot access value of token: continue\""*/,};second = new CatTag[]{ };
return new Pair(first, second);
 // default
case 48:
 
			first = new CatTag[]{ CatTag.TOK_default /* "error"cannot access value of token: default\""*/,};second = new CatTag[]{ };
return new Pair(first, second);
 // do
case 49:
 
			first = new CatTag[]{ CatTag.TOK_do /* "error"cannot access value of token: do\""*/,};second = new CatTag[]{ };
return new Pair(first, second);
 // double
case 50:
 
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* unsafeCoerce# (Type (Tdouble))*/, CatTag.CAT_Spec_qual /* unsafeCoerce# (TypeSpec (Tdouble))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tdouble)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tdouble)))*/, CatTag.CAT_Parameter_declarations /* unsafeCoerce# (ParamDec (OnlyType ((:[]) (Type (Tdouble)))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tdouble)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tdouble)))*/, CatTag.CAT_Parameter_declaration /* unsafeCoerce# (OnlyType ((:[]) (Type (Tdouble))))*/, CatTag.CAT_Type_name /* unsafeCoerce# (PlainType ((:[]) (TypeSpec (Tdouble))))*/, CatTag.CAT_Parameter_type /* unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Type (Tdouble))))))*/,};
return new Pair(first, second);
 // else
case 51:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_else /* "error"cannot access value of token: else\""*/,};
return new Pair(first, second);
 // enum
case 52:
 
			first = new CatTag[]{ CatTag.TOK_enum /* "error"cannot access value of token: enum\""*/,};second = new CatTag[]{ };
return new Pair(first, second);
 // extern
case 53:
 
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* unsafeCoerce# (Storage (GlobalPrograms))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Storage (GlobalPrograms)))*/, CatTag.CAT_Parameter_declarations /* unsafeCoerce# (ParamDec (OnlyType ((:[]) (Storage (GlobalPrograms)))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Storage (GlobalPrograms)))*/, CatTag.CAT_Parameter_declaration /* unsafeCoerce# (OnlyType ((:[]) (Storage (GlobalPrograms))))*/, CatTag.CAT_Parameter_type /* unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Storage (GlobalPrograms))))))*/,};
return new Pair(first, second);
 // float
case 54:
 
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* unsafeCoerce# (Type (Tfloat))*/, CatTag.CAT_Spec_qual /* unsafeCoerce# (TypeSpec (Tfloat))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tfloat)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tfloat)))*/, CatTag.CAT_Parameter_declarations /* unsafeCoerce# (ParamDec (OnlyType ((:[]) (Type (Tfloat)))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tfloat)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tfloat)))*/, CatTag.CAT_Parameter_declaration /* unsafeCoerce# (OnlyType ((:[]) (Type (Tfloat))))*/, CatTag.CAT_Type_name /* unsafeCoerce# (PlainType ((:[]) (TypeSpec (Tfloat))))*/, CatTag.CAT_Parameter_type /* unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Type (Tfloat))))))*/,};
return new Pair(first, second);
 // for
case 55:
 
			first = new CatTag[]{ CatTag.TOK_for /* "error"cannot access value of token: for\""*/,};second = new CatTag[]{ };
return new Pair(first, second);
 // goto
case 56:
 
			first = new CatTag[]{ CatTag.TOK_goto /* "error"cannot access value of token: goto\""*/,};second = new CatTag[]{ };
return new Pair(first, second);
 // if
case 57:
 
			first = new CatTag[]{ CatTag.TOK_if /* "error"cannot access value of token: if\""*/,};second = new CatTag[]{ };
return new Pair(first, second);
 // int
case 58:
 
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* unsafeCoerce# (Type (Tint))*/, CatTag.CAT_Spec_qual /* unsafeCoerce# (TypeSpec (Tint))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tint)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tint)))*/, CatTag.CAT_Parameter_declarations /* unsafeCoerce# (ParamDec (OnlyType ((:[]) (Type (Tint)))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tint)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tint)))*/, CatTag.CAT_Parameter_declaration /* unsafeCoerce# (OnlyType ((:[]) (Type (Tint))))*/, CatTag.CAT_Type_name /* unsafeCoerce# (PlainType ((:[]) (TypeSpec (Tint))))*/, CatTag.CAT_Parameter_type /* unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Type (Tint))))))*/,};
return new Pair(first, second);
 // long
case 59:
 
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* unsafeCoerce# (Type (Tlong))*/, CatTag.CAT_Spec_qual /* unsafeCoerce# (TypeSpec (Tlong))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tlong)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tlong)))*/, CatTag.CAT_Parameter_declarations /* unsafeCoerce# (ParamDec (OnlyType ((:[]) (Type (Tlong)))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tlong)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tlong)))*/, CatTag.CAT_Parameter_declaration /* unsafeCoerce# (OnlyType ((:[]) (Type (Tlong))))*/, CatTag.CAT_Type_name /* unsafeCoerce# (PlainType ((:[]) (TypeSpec (Tlong))))*/, CatTag.CAT_Parameter_type /* unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Type (Tlong))))))*/,};
return new Pair(first, second);
 // register
case 60:
 
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* unsafeCoerce# (Storage (LocalReg))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Storage (LocalReg)))*/, CatTag.CAT_Parameter_declarations /* unsafeCoerce# (ParamDec (OnlyType ((:[]) (Storage (LocalReg)))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Storage (LocalReg)))*/, CatTag.CAT_Parameter_declaration /* unsafeCoerce# (OnlyType ((:[]) (Storage (LocalReg))))*/, CatTag.CAT_Parameter_type /* unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Storage (LocalReg))))))*/,};
return new Pair(first, second);
 // return
case 61:
 
			first = new CatTag[]{ CatTag.TOK_return /* "error"cannot access value of token: return\""*/,};second = new CatTag[]{ };
return new Pair(first, second);
 // short
case 62:
 
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* unsafeCoerce# (Type (Tshort))*/, CatTag.CAT_Spec_qual /* unsafeCoerce# (TypeSpec (Tshort))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tshort)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tshort)))*/, CatTag.CAT_Parameter_declarations /* unsafeCoerce# (ParamDec (OnlyType ((:[]) (Type (Tshort)))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tshort)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tshort)))*/, CatTag.CAT_Parameter_declaration /* unsafeCoerce# (OnlyType ((:[]) (Type (Tshort))))*/, CatTag.CAT_Type_name /* unsafeCoerce# (PlainType ((:[]) (TypeSpec (Tshort))))*/, CatTag.CAT_Parameter_type /* unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Type (Tshort))))))*/,};
return new Pair(first, second);
 // signed
case 63:
 
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* unsafeCoerce# (Type (Tsigned))*/, CatTag.CAT_Spec_qual /* unsafeCoerce# (TypeSpec (Tsigned))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tsigned)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tsigned)))*/, CatTag.CAT_Parameter_declarations /* unsafeCoerce# (ParamDec (OnlyType ((:[]) (Type (Tsigned)))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tsigned)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tsigned)))*/, CatTag.CAT_Parameter_declaration /* unsafeCoerce# (OnlyType ((:[]) (Type (Tsigned))))*/, CatTag.CAT_Type_name /* unsafeCoerce# (PlainType ((:[]) (TypeSpec (Tsigned))))*/, CatTag.CAT_Parameter_type /* unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Type (Tsigned))))))*/,};
return new Pair(first, second);
 // sizeof
case 64:
 
			first = new CatTag[]{ CatTag.TOK_sizeof /* "error"cannot access value of token: sizeof\""*/,};second = new CatTag[]{ };
return new Pair(first, second);
 // static
case 65:
 
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* unsafeCoerce# (Storage (LocalProgram))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Storage (LocalProgram)))*/, CatTag.CAT_Parameter_declarations /* unsafeCoerce# (ParamDec (OnlyType ((:[]) (Storage (LocalProgram)))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Storage (LocalProgram)))*/, CatTag.CAT_Parameter_declaration /* unsafeCoerce# (OnlyType ((:[]) (Storage (LocalProgram))))*/, CatTag.CAT_Parameter_type /* unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Storage (LocalProgram))))))*/,};
return new Pair(first, second);
 // struct
case 66:
 
			first = new CatTag[]{ CatTag.CAT_Struct_or_union /* unsafeCoerce# (Struct)*/,};second = new CatTag[]{ };
return new Pair(first, second);
 // switch
case 67:
 
			first = new CatTag[]{ CatTag.TOK_switch /* "error"cannot access value of token: switch\""*/,};second = new CatTag[]{ };
return new Pair(first, second);
 // typedef
case 68:
 
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* unsafeCoerce# (Storage (MyType))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Storage (MyType)))*/, CatTag.CAT_Parameter_declarations /* unsafeCoerce# (ParamDec (OnlyType ((:[]) (Storage (MyType)))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Storage (MyType)))*/, CatTag.CAT_Parameter_declaration /* unsafeCoerce# (OnlyType ((:[]) (Storage (MyType))))*/, CatTag.CAT_Parameter_type /* unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Storage (MyType))))))*/,};
return new Pair(first, second);
 // union
case 69:
 
			first = new CatTag[]{ CatTag.CAT_Struct_or_union /* unsafeCoerce# (Union)*/,};second = new CatTag[]{ };
return new Pair(first, second);
 // unsigned
case 70:
 
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* unsafeCoerce# (Type (Tunsigned))*/, CatTag.CAT_Spec_qual /* unsafeCoerce# (TypeSpec (Tunsigned))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tunsigned)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tunsigned)))*/, CatTag.CAT_Parameter_declarations /* unsafeCoerce# (ParamDec (OnlyType ((:[]) (Type (Tunsigned)))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tunsigned)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tunsigned)))*/, CatTag.CAT_Parameter_declaration /* unsafeCoerce# (OnlyType ((:[]) (Type (Tunsigned))))*/, CatTag.CAT_Type_name /* unsafeCoerce# (PlainType ((:[]) (TypeSpec (Tunsigned))))*/, CatTag.CAT_Parameter_type /* unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Type (Tunsigned))))))*/,};
return new Pair(first, second);
 // void
case 71:
 
			first = new CatTag[]{ CatTag.CAT_Declaration_specifier /* unsafeCoerce# (Type (Tvoid))*/, CatTag.CAT_Spec_qual /* unsafeCoerce# (TypeSpec (Tvoid))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tvoid)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tvoid)))*/, CatTag.CAT_Parameter_declarations /* unsafeCoerce# (ParamDec (OnlyType ((:[]) (Type (Tvoid)))))*/,};second = new CatTag[]{ CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (Type (Tvoid)))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (TypeSpec (Tvoid)))*/, CatTag.CAT_Parameter_declaration /* unsafeCoerce# (OnlyType ((:[]) (Type (Tvoid))))*/, CatTag.CAT_Type_name /* unsafeCoerce# (PlainType ((:[]) (TypeSpec (Tvoid))))*/, CatTag.CAT_Parameter_type /* unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (Type (Tvoid))))))*/,};
return new Pair(first, second);
 // volatile
case 72:
 
			first = new CatTag[]{ CatTag.CAT_Type_qualifier /* unsafeCoerce# (NoOptim)*/, CatTag.CAT_Spec_qual /* unsafeCoerce# (QualSpec (NoOptim))*/, CatTag.CAT_Declaration_specifier /* unsafeCoerce# (SpecProp (NoOptim))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (QualSpec (NoOptim)))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (SpecProp (NoOptim)))*/, CatTag.CAT_Parameter_declarations /* unsafeCoerce# (ParamDec (OnlyType ((:[]) (SpecProp (NoOptim)))))*/,};second = new CatTag[]{ CatTag.CAT_Type_qualifier_List /* unsafeCoerce# ((:[]) (NoOptim))*/, CatTag.CAT_Spec_qual_List /* unsafeCoerce# ((:[]) (QualSpec (NoOptim)))*/, CatTag.CAT_Declaration_specifier_List /* unsafeCoerce# ((:[]) (SpecProp (NoOptim)))*/, CatTag.CAT_Parameter_declaration /* unsafeCoerce# (OnlyType ((:[]) (SpecProp (NoOptim))))*/, CatTag.CAT_Type_name /* unsafeCoerce# (PlainType ((:[]) (QualSpec (NoOptim))))*/, CatTag.CAT_Parameter_type /* unsafeCoerce# (AllSpec (ParamDec (OnlyType ((:[]) (SpecProp (NoOptim))))))*/,};
return new Pair(first, second);
 // while
case 73:
 
			first = new CatTag[]{ CatTag.TOK_while /* "error"cannot access value of token: while\""*/,};second = new CatTag[]{ CatTag.TOK_while /* "error"cannot access value of token: while\""*/,};
return new Pair(first, second);
 // {
case 74:
 
			first = new CatTag[]{ CatTag.TOK_OPEN_ /* "error"cannot access value of token: {\""*/,};second = new CatTag[]{ CatTag.TOK_OPEN_ /* "error"cannot access value of token: {\""*/,};
return new Pair(first, second);
 // |
case 75:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_124 /* "error"cannot access value of token: |\""*/,};
return new Pair(first, second);
 // |=
case 76:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.CAT_Assignment_op /* unsafeCoerce# (AssignOr)*/,};
return new Pair(first, second);
 // ||
case 77:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_124124 /* "error"cannot access value of token: ||\""*/,};
return new Pair(first, second);
 // }
case 78:
 
			first = new CatTag[]{ };second = new CatTag[]{ CatTag.TOK_CLOS_ /* "error"cannot access value of token: }\""*/,};
return new Pair(first, second);
 // ~
case 79:
 
			first = new CatTag[]{ CatTag.CAT_Unary_operator /* unsafeCoerce# (Complement)*/,};second = new CatTag[]{ };
return new Pair(first, second);
default: return null;	}
	}
/*Normalised grammar:
  Progr. Program ::= "[External_declaration]"
(:[]). [External_declaration] ::= "External_declaration"
(:). [External_declaration] ::= "External_declaration" "[External_declaration]"
Afunc. External_declaration ::= "Function_def"
Global. External_declaration ::= "Dec"
($). Function_def ::= "0" "Compound_stm"
($). 0 ::= "1" "[Dec]"
OldFunc. 1 ::= "[Declaration_specifier]" "Declarator"
($). Function_def ::= "2" "Compound_stm"
NewFunc. 2 ::= "[Declaration_specifier]" "Declarator"
($). Function_def ::= "3" "Compound_stm"
OldFuncInt. 3 ::= "Declarator" "[Dec]"
NewFuncInt. Function_def ::= "Declarator" "Compound_stm"
NoDeclarator. Dec ::= "[Declaration_specifier]" ;
($). Dec ::= "4" ;
Declarators. 4 ::= "[Declaration_specifier]" "[Init_declarator]"
(:[]). [Dec] ::= "Dec"
(:). [Dec] ::= "Dec" "[Dec]"
(:[]). [Declaration_specifier] ::= "Declaration_specifier"
(:). [Declaration_specifier] ::= "Declaration_specifier" "[Declaration_specifier]"
Type. Declaration_specifier ::= "Type_specifier"
Storage. Declaration_specifier ::= "Storage_class_specifier"
SpecProp. Declaration_specifier ::= "Type_qualifier"
(:[]). [Init_declarator] ::= "Init_declarator"
($). [Init_declarator] ::= "5" "[Init_declarator]"
(:). 5 ::= "Init_declarator" ,
OnlyDecl. Init_declarator ::= "Declarator"
($). Init_declarator ::= "6" "Initz"
InitDecl. 6 ::= "Declarator" =
Tvoid. Type_specifier ::= void
Tchar. Type_specifier ::= char
Tshort. Type_specifier ::= short
Tint. Type_specifier ::= int
Tlong. Type_specifier ::= long
Tfloat. Type_specifier ::= float
Tdouble. Type_specifier ::= double
Tsigned. Type_specifier ::= signed
Tunsigned. Type_specifier ::= unsigned
Tstruct. Type_specifier ::= "Struct_or_union_spec"
Tenum. Type_specifier ::= "Enum_specifier"
Tname. Type_specifier ::= Typedef_name
MyType. Storage_class_specifier ::= typedef
GlobalPrograms. Storage_class_specifier ::= extern
LocalProgram. Storage_class_specifier ::= static
LocalBlock. Storage_class_specifier ::= auto
LocalReg. Storage_class_specifier ::= register
Const. Type_qualifier ::= const
NoOptim. Type_qualifier ::= volatile
($). Struct_or_union_spec ::= "7" }
($). 7 ::= "8" "[Struct_dec]"
($). 8 ::= "9" {
Tag. 9 ::= "Struct_or_union" "Ident"
($). Struct_or_union_spec ::= "10" }
($). 10 ::= "11" "[Struct_dec]"
Unique. 11 ::= "Struct_or_union" {
TagType. Struct_or_union_spec ::= "Struct_or_union" "Ident"
Struct. Struct_or_union ::= struct
Union. Struct_or_union ::= union
(:[]). [Struct_dec] ::= "Struct_dec"
(:). [Struct_dec] ::= "Struct_dec" "[Struct_dec]"
($). Struct_dec ::= "12" ;
Structen. 12 ::= "[Spec_qual]" "[Struct_declarator]"
(:[]). [Spec_qual] ::= "Spec_qual"
(:). [Spec_qual] ::= "Spec_qual" "[Spec_qual]"
TypeSpec. Spec_qual ::= "Type_specifier"
QualSpec. Spec_qual ::= "Type_qualifier"
(:[]). [Struct_declarator] ::= "Struct_declarator"
($). [Struct_declarator] ::= "13" "[Struct_declarator]"
(:). 13 ::= "Struct_declarator" ,
Decl. Struct_declarator ::= "Declarator"
Field. Struct_declarator ::= : "Constant_expression"
($). Struct_declarator ::= "14" "Constant_expression"
DecField. 14 ::= "Declarator" :
($). Enum_specifier ::= "15" }
($). 15 ::= "16" "[Enumerator]"
EnumDec. 16 ::= enum {
($). Enum_specifier ::= "17" }
($). 17 ::= "18" "[Enumerator]"
($). 18 ::= "19" {
EnumName. 19 ::= enum "Ident"
EnumVar. Enum_specifier ::= enum "Ident"
(:[]). [Enumerator] ::= "Enumerator"
($). [Enumerator] ::= "20" "[Enumerator]"
(:). 20 ::= "Enumerator" ,
Plain. Enumerator ::= "Ident"
($). Enumerator ::= "21" "Constant_expression"
EnumInit. 21 ::= "Ident" =
BeginPointer. Declarator ::= "Pointer" "Direct_declarator"
NoPointer. Declarator ::= "Direct_declarator"
Name. Direct_declarator ::= "Ident"
($). Direct_declarator ::= "22" )
ParenDecl. 22 ::= ( "Declarator"
($). Direct_declarator ::= "23" ]
($). 23 ::= "24" "Constant_expression"
InnitArray. 24 ::= "Direct_declarator" [
($). Direct_declarator ::= "25" ]
Incomplete. 25 ::= "Direct_declarator" [
($). Direct_declarator ::= "26" )
($). 26 ::= "27" "Parameter_type"
NewFuncDec. 27 ::= "Direct_declarator" (
($). Direct_declarator ::= "28" )
($). 28 ::= "29" "[Ident]"
OldFuncDef. 29 ::= "Direct_declarator" (
($). Direct_declarator ::= "30" )
OldFuncDec. 30 ::= "Direct_declarator" (
Point. Pointer ::= *
PointQual. Pointer ::= * "[Type_qualifier]"
PointPoint. Pointer ::= * "Pointer"
($). Pointer ::= "31" "Pointer"
PointQualPoint. 31 ::= * "[Type_qualifier]"
(:[]). [Type_qualifier] ::= "Type_qualifier"
(:). [Type_qualifier] ::= "Type_qualifier" "[Type_qualifier]"
AllSpec. Parameter_type ::= "Parameter_declarations"
($). Parameter_type ::= "32" ...
More. 32 ::= "Parameter_declarations" ,
ParamDec. Parameter_declarations ::= "Parameter_declaration"
($). Parameter_declarations ::= "33" "Parameter_declaration"
MoreParamDec. 33 ::= "Parameter_declarations" ,
OnlyType. Parameter_declaration ::= "[Declaration_specifier]"
TypeAndParam. Parameter_declaration ::= "[Declaration_specifier]" "Declarator"
Abstract. Parameter_declaration ::= "[Declaration_specifier]" "Abstract_declarator"
(:[]). [Ident] ::= "Ident"
($). [Ident] ::= "34" "[Ident]"
(:). 34 ::= "Ident" ,
InitExpr. Initz ::= "Exp2"
($). Initz ::= "35" }
InitListOne. 35 ::= { "Initializers"
($). Initz ::= "36" }
($). 36 ::= "37" ,
InitListTwo. 37 ::= { "Initializers"
AnInit. Initializers ::= "Initz"
($). Initializers ::= "38" "Initz"
MoreInit. 38 ::= "Initializers" ,
PlainType. Type_name ::= "[Spec_qual]"
ExtendedType. Type_name ::= "[Spec_qual]" "Abstract_declarator"
PointerStart. Abstract_declarator ::= "Pointer"
Advanced. Abstract_declarator ::= "Dir_abs_dec"
PointAdvanced. Abstract_declarator ::= "Pointer" "Dir_abs_dec"
($). Dir_abs_dec ::= "39" )
WithinParentes. 39 ::= ( "Abstract_declarator"
Array. Dir_abs_dec ::= [ ]
($). Dir_abs_dec ::= "40" ]
InitiatedArray. 40 ::= [ "Constant_expression"
($). Dir_abs_dec ::= "41" ]
UnInitiated. 41 ::= "Dir_abs_dec" [
($). Dir_abs_dec ::= "42" ]
($). 42 ::= "43" "Constant_expression"
Initiated. 43 ::= "Dir_abs_dec" [
OldFunction. Dir_abs_dec ::= ( )
($). Dir_abs_dec ::= "44" )
NewFunction. 44 ::= ( "Parameter_type"
($). Dir_abs_dec ::= "45" )
OldFuncExpr. 45 ::= "Dir_abs_dec" (
($). Dir_abs_dec ::= "46" )
($). 46 ::= "47" "Parameter_type"
NewFuncExpr. 47 ::= "Dir_abs_dec" (
LabelS. Stm ::= "Labeled_stm"
CompS. Stm ::= "Compound_stm"
ExprS. Stm ::= "Expression_stm"
SelS. Stm ::= "Selection_stm"
IterS. Stm ::= "Iter_stm"
JumpS. Stm ::= "Jump_stm"
($). Labeled_stm ::= "48" "Stm"
SlabelOne. 48 ::= "Ident" :
($). Labeled_stm ::= "49" "Stm"
($). 49 ::= "50" :
SlabelTwo. 50 ::= case "Constant_expression"
($). Labeled_stm ::= "51" "Stm"
SlabelThree. 51 ::= default :
ScompOne. Compound_stm ::= { }
($). Compound_stm ::= "52" }
ScompTwo. 52 ::= { "[Stm]"
($). Compound_stm ::= "53" }
ScompThree. 53 ::= { "[Dec]"
($). Compound_stm ::= "54" }
($). 54 ::= "55" "[Stm]"
ScompFour. 55 ::= { "[Dec]"
SexprOne. Expression_stm ::= ;
SexprTwo. Expression_stm ::= "Exp" ;
($). Selection_stm ::= "56" "Stm"
($). 56 ::= "57" )
($). 57 ::= "58" "Exp"
SselOne. 58 ::= if (
($). Selection_stm ::= "59" "Stm"
($). 59 ::= "60" else
($). 60 ::= "61" "Stm"
($). 61 ::= "62" )
($). 62 ::= "63" "Exp"
SselTwo. 63 ::= if (
($). Selection_stm ::= "64" "Stm"
($). 64 ::= "65" )
($). 65 ::= "66" "Exp"
SselThree. 66 ::= switch (
($). Iter_stm ::= "67" "Stm"
($). 67 ::= "68" )
($). 68 ::= "69" "Exp"
SiterOne. 69 ::= while (
($). Iter_stm ::= "70" ;
($). 70 ::= "71" )
($). 71 ::= "72" "Exp"
($). 72 ::= "73" (
($). 73 ::= "74" while
SiterTwo. 74 ::= do "Stm"
($). Iter_stm ::= "75" "Stm"
($). 75 ::= "76" )
($). 76 ::= "77" "Expression_stm"
($). 77 ::= "78" "Expression_stm"
SiterThree. 78 ::= for (
($). Iter_stm ::= "79" "Stm"
($). 79 ::= "80" )
($). 80 ::= "81" "Exp"
($). 81 ::= "82" "Expression_stm"
($). 82 ::= "83" "Expression_stm"
SiterFour. 83 ::= for (
($). Jump_stm ::= "84" ;
SjumpOne. 84 ::= goto "Ident"
SjumpTwo. Jump_stm ::= continue ;
SjumpThree. Jump_stm ::= break ;
SjumpFour. Jump_stm ::= return ;
($). Jump_stm ::= "85" ;
SjumpFive. 85 ::= return "Exp"
(:[]). [Stm] ::= "Stm"
(:). [Stm] ::= "Stm" "[Stm]"
($). Exp ::= "86" "Exp2"
Ecomma. 86 ::= "Exp" ,
($). Exp2 ::= "87" "Exp2"
Eassign. 87 ::= "Exp15" "Assignment_op"
($). Exp3 ::= "88" "Exp3"
($). 88 ::= "89" :
($). 89 ::= "90" "Exp"
Econdition. 90 ::= "Exp4" ?
($). Exp4 ::= "91" "Exp5"
Elor. 91 ::= "Exp4" ||
($). Exp5 ::= "92" "Exp6"
Eland. 92 ::= "Exp5" &&
($). Exp6 ::= "93" "Exp7"
Ebitor. 93 ::= "Exp6" |
($). Exp7 ::= "94" "Exp8"
Ebitexor. 94 ::= "Exp7" ^
($). Exp8 ::= "95" "Exp9"
Ebitand. 95 ::= "Exp8" &
($). Exp9 ::= "96" "Exp10"
Eeq. 96 ::= "Exp9" ==
($). Exp9 ::= "97" "Exp10"
Eneq. 97 ::= "Exp9" !=
($). Exp10 ::= "98" "Exp11"
Elthen. 98 ::= "Exp10" <
($). Exp10 ::= "99" "Exp11"
Egrthen. 99 ::= "Exp10" >
($). Exp10 ::= "100" "Exp11"
Ele. 100 ::= "Exp10" <=
($). Exp10 ::= "101" "Exp11"
Ege. 101 ::= "Exp10" >=
($). Exp11 ::= "102" "Exp12"
Eleft. 102 ::= "Exp11" <<
($). Exp11 ::= "103" "Exp12"
Eright. 103 ::= "Exp11" >>
($). Exp12 ::= "104" "Exp13"
Eplus. 104 ::= "Exp12" +
($). Exp12 ::= "105" "Exp13"
Eminus. 105 ::= "Exp12" -
($). Exp13 ::= "106" "Exp14"
Etimes. 106 ::= "Exp13" *
($). Exp13 ::= "107" "Exp14"
Ediv. 107 ::= "Exp13" /
($). Exp13 ::= "108" "Exp14"
Emod. 108 ::= "Exp13" %
($). Exp14 ::= "109" "Exp14"
($). 109 ::= "110" )
Etypeconv. 110 ::= ( "Type_name"
Epreinc. Exp15 ::= ++ "Exp15"
Epredec. Exp15 ::= -- "Exp15"
Epreop. Exp15 ::= "Unary_operator" "Exp14"
Ebytesexpr. Exp15 ::= sizeof "Exp15"
($). Exp15 ::= "111" )
($). 111 ::= "112" "Type_name"
Ebytestype. 112 ::= sizeof (
($). Exp16 ::= "113" ]
($). 113 ::= "114" "Exp"
Earray. 114 ::= "Exp16" [
($). Exp16 ::= "115" )
Efunk. 115 ::= "Exp16" (
($). Exp16 ::= "116" )
($). 116 ::= "117" "[Exp2]"
Efunkpar. 117 ::= "Exp16" (
($). Exp16 ::= "118" "Ident"
Eselect. 118 ::= "Exp16" .
($). Exp16 ::= "119" "Ident"
Epoint. 119 ::= "Exp16" ->
Epostinc. Exp16 ::= "Exp16" ++
Epostdec. Exp16 ::= "Exp16" --
Evar. Exp17 ::= "Ident"
Econst. Exp17 ::= "Constant"
Estring. Exp17 ::= "String"
Efloat. Constant ::= "Double"
Echar. Constant ::= "Char"
Eunsigned. Constant ::= "Unsigned"
Elong. Constant ::= "Long"
Eunsignlong. Constant ::= "UnsignedLong"
Ehexadec. Constant ::= "Hexadecimal"
Ehexaunsign. Constant ::= "HexUnsigned"
Ehexalong. Constant ::= "HexLong"
Ehexaunslong. Constant ::= "HexUnsLong"
Eoctal. Constant ::= "Octal"
Eoctalunsign. Constant ::= "OctalUnsigned"
Eoctallong. Constant ::= "OctalLong"
Eoctalunslong. Constant ::= "OctalUnsLong"
Ecdouble. Constant ::= "CDouble"
Ecfloat. Constant ::= "CFloat"
Eclongdouble. Constant ::= "CLongDouble"
Eint. Constant ::= "Integer"
Especial. Constant_expression ::= "Exp3"
id. Exp ::= "Exp2"
id. Exp2 ::= "Exp3"
id. Exp3 ::= "Exp4"
id. Exp4 ::= "Exp5"
id. Exp5 ::= "Exp6"
id. Exp6 ::= "Exp7"
id. Exp7 ::= "Exp8"
id. Exp8 ::= "Exp9"
id. Exp9 ::= "Exp10"
id. Exp10 ::= "Exp11"
id. Exp11 ::= "Exp12"
id. Exp12 ::= "Exp13"
id. Exp13 ::= "Exp14"
id. Exp14 ::= "Exp15"
id. Exp15 ::= "Exp16"
id. Exp16 ::= "Exp17"
($). Exp17 ::= "120" )
id. 120 ::= ( "Exp"
Address. Unary_operator ::= &
Indirection. Unary_operator ::= *
Plus. Unary_operator ::= +
Negative. Unary_operator ::= -
Complement. Unary_operator ::= ~
Logicalneg. Unary_operator ::= !
(:[]). [Exp2] ::= "Exp2"
($). [Exp2] ::= "121" "[Exp2]"
(:). 121 ::= "Exp2" ,
Assign. Assignment_op ::= =
AssignMul. Assignment_op ::= *=
AssignDiv. Assignment_op ::= /=
AssignMod. Assignment_op ::= %=
AssignAdd. Assignment_op ::= +=
AssignSub. Assignment_op ::= -=
AssignLeft. Assignment_op ::= <<=
AssignRight. Assignment_op ::= >>=
AssignAnd. Assignment_op ::= &=
AssignXor. Assignment_op ::= ^=
AssignOr. Assignment_op ::= |=

  Unit relation:
  Ecdouble : CAT_CDouble --> Constant
  (Econst).(Ecdouble) : CAT_CDouble --> Exp17
  (Econst).(Ecdouble) : CAT_CDouble --> Exp16
  (Econst).(Ecdouble) : CAT_CDouble --> Exp15
  (Econst).(Ecdouble) : CAT_CDouble --> Exp14
  (Econst).(Ecdouble) : CAT_CDouble --> Exp13
  (Econst).(Ecdouble) : CAT_CDouble --> Exp12
  (Econst).(Ecdouble) : CAT_CDouble --> Exp11
  (Econst).(Ecdouble) : CAT_CDouble --> Exp10
  (Econst).(Ecdouble) : CAT_CDouble --> Exp9
  (Econst).(Ecdouble) : CAT_CDouble --> Exp8
  (Econst).(Ecdouble) : CAT_CDouble --> Exp7
  (Econst).(Ecdouble) : CAT_CDouble --> Exp6
  (Econst).(Ecdouble) : CAT_CDouble --> Exp5
  (Econst).(Ecdouble) : CAT_CDouble --> Exp4
  (Econst).(Ecdouble) : CAT_CDouble --> Exp3
  (Econst).(Ecdouble) : CAT_CDouble --> Exp
  (Econst).(Ecdouble) : CAT_CDouble --> Exp2
  (((:[])).(Econst)).(Ecdouble) : CAT_CDouble --> [Exp2]
  ((Especial).(Econst)).(Ecdouble) : CAT_CDouble --> Constant_expression
  ((InitExpr).(Econst)).(Ecdouble) : CAT_CDouble --> Initz
  (((AnInit).(InitExpr)).(Econst)).(Ecdouble) : CAT_CDouble --> Initializers
  Ecfloat : CAT_CFloat --> Constant
  (Econst).(Ecfloat) : CAT_CFloat --> Exp17
  (Econst).(Ecfloat) : CAT_CFloat --> Exp16
  (Econst).(Ecfloat) : CAT_CFloat --> Exp15
  (Econst).(Ecfloat) : CAT_CFloat --> Exp14
  (Econst).(Ecfloat) : CAT_CFloat --> Exp13
  (Econst).(Ecfloat) : CAT_CFloat --> Exp12
  (Econst).(Ecfloat) : CAT_CFloat --> Exp11
  (Econst).(Ecfloat) : CAT_CFloat --> Exp10
  (Econst).(Ecfloat) : CAT_CFloat --> Exp9
  (Econst).(Ecfloat) : CAT_CFloat --> Exp8
  (Econst).(Ecfloat) : CAT_CFloat --> Exp7
  (Econst).(Ecfloat) : CAT_CFloat --> Exp6
  (Econst).(Ecfloat) : CAT_CFloat --> Exp5
  (Econst).(Ecfloat) : CAT_CFloat --> Exp4
  (Econst).(Ecfloat) : CAT_CFloat --> Exp3
  (Econst).(Ecfloat) : CAT_CFloat --> Exp
  (Econst).(Ecfloat) : CAT_CFloat --> Exp2
  (((:[])).(Econst)).(Ecfloat) : CAT_CFloat --> [Exp2]
  ((Especial).(Econst)).(Ecfloat) : CAT_CFloat --> Constant_expression
  ((InitExpr).(Econst)).(Ecfloat) : CAT_CFloat --> Initz
  (((AnInit).(InitExpr)).(Econst)).(Ecfloat) : CAT_CFloat --> Initializers
  Eclongdouble : CAT_CLongDouble --> Constant
  (Econst).(Eclongdouble) : CAT_CLongDouble --> Exp17
  (Econst).(Eclongdouble) : CAT_CLongDouble --> Exp16
  (Econst).(Eclongdouble) : CAT_CLongDouble --> Exp15
  (Econst).(Eclongdouble) : CAT_CLongDouble --> Exp14
  (Econst).(Eclongdouble) : CAT_CLongDouble --> Exp13
  (Econst).(Eclongdouble) : CAT_CLongDouble --> Exp12
  (Econst).(Eclongdouble) : CAT_CLongDouble --> Exp11
  (Econst).(Eclongdouble) : CAT_CLongDouble --> Exp10
  (Econst).(Eclongdouble) : CAT_CLongDouble --> Exp9
  (Econst).(Eclongdouble) : CAT_CLongDouble --> Exp8
  (Econst).(Eclongdouble) : CAT_CLongDouble --> Exp7
  (Econst).(Eclongdouble) : CAT_CLongDouble --> Exp6
  (Econst).(Eclongdouble) : CAT_CLongDouble --> Exp5
  (Econst).(Eclongdouble) : CAT_CLongDouble --> Exp4
  (Econst).(Eclongdouble) : CAT_CLongDouble --> Exp3
  (Econst).(Eclongdouble) : CAT_CLongDouble --> Exp
  (Econst).(Eclongdouble) : CAT_CLongDouble --> Exp2
  (((:[])).(Econst)).(Eclongdouble) : CAT_CLongDouble --> [Exp2]
  ((Especial).(Econst)).(Eclongdouble) : CAT_CLongDouble --> Constant_expression
  ((InitExpr).(Econst)).(Eclongdouble) : CAT_CLongDouble --> Initz
  (((AnInit).(InitExpr)).(Econst)).(Eclongdouble) : CAT_CLongDouble --> Initializers
  Echar : CAT_Char --> Constant
  (Econst).(Echar) : CAT_Char --> Exp17
  (Econst).(Echar) : CAT_Char --> Exp16
  (Econst).(Echar) : CAT_Char --> Exp15
  (Econst).(Echar) : CAT_Char --> Exp14
  (Econst).(Echar) : CAT_Char --> Exp13
  (Econst).(Echar) : CAT_Char --> Exp12
  (Econst).(Echar) : CAT_Char --> Exp11
  (Econst).(Echar) : CAT_Char --> Exp10
  (Econst).(Echar) : CAT_Char --> Exp9
  (Econst).(Echar) : CAT_Char --> Exp8
  (Econst).(Echar) : CAT_Char --> Exp7
  (Econst).(Echar) : CAT_Char --> Exp6
  (Econst).(Echar) : CAT_Char --> Exp5
  (Econst).(Echar) : CAT_Char --> Exp4
  (Econst).(Echar) : CAT_Char --> Exp3
  (Econst).(Echar) : CAT_Char --> Exp
  (Econst).(Echar) : CAT_Char --> Exp2
  (((:[])).(Econst)).(Echar) : CAT_Char --> [Exp2]
  ((Especial).(Econst)).(Echar) : CAT_Char --> Constant_expression
  ((InitExpr).(Econst)).(Echar) : CAT_Char --> Initz
  (((AnInit).(InitExpr)).(Econst)).(Echar) : CAT_Char --> Initializers
  CompS : CAT_Compound_stm --> Stm
  ((:[])).(CompS) : CAT_Compound_stm --> [Stm]
  Econst : CAT_Constant --> Exp17
  Econst : CAT_Constant --> Exp16
  Econst : CAT_Constant --> Exp15
  Econst : CAT_Constant --> Exp14
  Econst : CAT_Constant --> Exp13
  Econst : CAT_Constant --> Exp12
  Econst : CAT_Constant --> Exp11
  Econst : CAT_Constant --> Exp10
  Econst : CAT_Constant --> Exp9
  Econst : CAT_Constant --> Exp8
  Econst : CAT_Constant --> Exp7
  Econst : CAT_Constant --> Exp6
  Econst : CAT_Constant --> Exp5
  Econst : CAT_Constant --> Exp4
  Econst : CAT_Constant --> Exp3
  Econst : CAT_Constant --> Exp
  Econst : CAT_Constant --> Exp2
  ((:[])).(Econst) : CAT_Constant --> [Exp2]
  (Especial).(Econst) : CAT_Constant --> Constant_expression
  (InitExpr).(Econst) : CAT_Constant --> Initz
  ((AnInit).(InitExpr)).(Econst) : CAT_Constant --> Initializers
  (:[]) : CAT_Dec --> [Dec]
  Global : CAT_Dec --> External_declaration
  ((:[])).(Global) : CAT_Dec --> [External_declaration]
  ((Progr).((:[]))).(Global) : CAT_Dec --> Program
  (:[]) : CAT_Declaration_specifier --> [Declaration_specifier]
  (OnlyType).((:[])) : CAT_Declaration_specifier --> Parameter_declaration
  ((ParamDec).(OnlyType)).((:[])) : CAT_Declaration_specifier --> Parameter_declarations
  (((AllSpec).(ParamDec)).(OnlyType)).((:[])) : CAT_Declaration_specifier --> Parameter_type
  Decl : CAT_Declarator --> Struct_declarator
  OnlyDecl : CAT_Declarator --> Init_declarator
  ((:[])).(Decl) : CAT_Declarator --> [Struct_declarator]
  ((:[])).(OnlyDecl) : CAT_Declarator --> [Init_declarator]
  Advanced : CAT_Dir_abs_dec --> Abstract_declarator
  NoPointer : CAT_Direct_declarator --> Declarator
  (Decl).(NoPointer) : CAT_Direct_declarator --> Struct_declarator
  (OnlyDecl).(NoPointer) : CAT_Direct_declarator --> Init_declarator
  (((:[])).(Decl)).(NoPointer) : CAT_Direct_declarator --> [Struct_declarator]
  (((:[])).(OnlyDecl)).(NoPointer) : CAT_Direct_declarator --> [Init_declarator]
  Efloat : CAT_Double --> Constant
  (Econst).(Efloat) : CAT_Double --> Exp17
  (Econst).(Efloat) : CAT_Double --> Exp16
  (Econst).(Efloat) : CAT_Double --> Exp15
  (Econst).(Efloat) : CAT_Double --> Exp14
  (Econst).(Efloat) : CAT_Double --> Exp13
  (Econst).(Efloat) : CAT_Double --> Exp12
  (Econst).(Efloat) : CAT_Double --> Exp11
  (Econst).(Efloat) : CAT_Double --> Exp10
  (Econst).(Efloat) : CAT_Double --> Exp9
  (Econst).(Efloat) : CAT_Double --> Exp8
  (Econst).(Efloat) : CAT_Double --> Exp7
  (Econst).(Efloat) : CAT_Double --> Exp6
  (Econst).(Efloat) : CAT_Double --> Exp5
  (Econst).(Efloat) : CAT_Double --> Exp4
  (Econst).(Efloat) : CAT_Double --> Exp3
  (Econst).(Efloat) : CAT_Double --> Exp
  (Econst).(Efloat) : CAT_Double --> Exp2
  (((:[])).(Econst)).(Efloat) : CAT_Double --> [Exp2]
  ((Especial).(Econst)).(Efloat) : CAT_Double --> Constant_expression
  ((InitExpr).(Econst)).(Efloat) : CAT_Double --> Initz
  (((AnInit).(InitExpr)).(Econst)).(Efloat) : CAT_Double --> Initializers
  Tenum : CAT_Enum_specifier --> Type_specifier
  (Type).(Tenum) : CAT_Enum_specifier --> Declaration_specifier
  (TypeSpec).(Tenum) : CAT_Enum_specifier --> Spec_qual
  (((:[])).(Type)).(Tenum) : CAT_Enum_specifier --> [Declaration_specifier]
  (((:[])).(TypeSpec)).(Tenum) : CAT_Enum_specifier --> [Spec_qual]
  (((OnlyType).((:[]))).(Type)).(Tenum) : CAT_Enum_specifier --> Parameter_declaration
  (((PlainType).((:[]))).(TypeSpec)).(Tenum) : CAT_Enum_specifier --> Type_name
  ((((ParamDec).(OnlyType)).((:[]))).(Type)).(Tenum) : CAT_Enum_specifier --> Parameter_declarations
  (((((AllSpec).(ParamDec)).(OnlyType)).((:[]))).(Type)).(Tenum) : CAT_Enum_specifier --> Parameter_type
  (:[]) : CAT_Enumerator --> [Enumerator]
  id : CAT_Exp10 --> Exp9
  id : CAT_Exp10 --> Exp8
  id : CAT_Exp10 --> Exp7
  id : CAT_Exp10 --> Exp6
  id : CAT_Exp10 --> Exp5
  id : CAT_Exp10 --> Exp4
  id : CAT_Exp10 --> Exp3
  id : CAT_Exp10 --> Exp
  id : CAT_Exp10 --> Exp2
  (:[]) : CAT_Exp10 --> [Exp2]
  Especial : CAT_Exp10 --> Constant_expression
  InitExpr : CAT_Exp10 --> Initz
  (AnInit).(InitExpr) : CAT_Exp10 --> Initializers
  id : CAT_Exp11 --> Exp10
  id : CAT_Exp11 --> Exp9
  id : CAT_Exp11 --> Exp8
  id : CAT_Exp11 --> Exp7
  id : CAT_Exp11 --> Exp6
  id : CAT_Exp11 --> Exp5
  id : CAT_Exp11 --> Exp4
  id : CAT_Exp11 --> Exp3
  id : CAT_Exp11 --> Exp
  id : CAT_Exp11 --> Exp2
  (:[]) : CAT_Exp11 --> [Exp2]
  Especial : CAT_Exp11 --> Constant_expression
  InitExpr : CAT_Exp11 --> Initz
  (AnInit).(InitExpr) : CAT_Exp11 --> Initializers
  id : CAT_Exp12 --> Exp11
  id : CAT_Exp12 --> Exp10
  id : CAT_Exp12 --> Exp9
  id : CAT_Exp12 --> Exp8
  id : CAT_Exp12 --> Exp7
  id : CAT_Exp12 --> Exp6
  id : CAT_Exp12 --> Exp5
  id : CAT_Exp12 --> Exp4
  id : CAT_Exp12 --> Exp3
  id : CAT_Exp12 --> Exp
  id : CAT_Exp12 --> Exp2
  (:[]) : CAT_Exp12 --> [Exp2]
  Especial : CAT_Exp12 --> Constant_expression
  InitExpr : CAT_Exp12 --> Initz
  (AnInit).(InitExpr) : CAT_Exp12 --> Initializers
  id : CAT_Exp13 --> Exp12
  id : CAT_Exp13 --> Exp11
  id : CAT_Exp13 --> Exp10
  id : CAT_Exp13 --> Exp9
  id : CAT_Exp13 --> Exp8
  id : CAT_Exp13 --> Exp7
  id : CAT_Exp13 --> Exp6
  id : CAT_Exp13 --> Exp5
  id : CAT_Exp13 --> Exp4
  id : CAT_Exp13 --> Exp3
  id : CAT_Exp13 --> Exp
  id : CAT_Exp13 --> Exp2
  (:[]) : CAT_Exp13 --> [Exp2]
  Especial : CAT_Exp13 --> Constant_expression
  InitExpr : CAT_Exp13 --> Initz
  (AnInit).(InitExpr) : CAT_Exp13 --> Initializers
  id : CAT_Exp14 --> Exp13
  id : CAT_Exp14 --> Exp12
  id : CAT_Exp14 --> Exp11
  id : CAT_Exp14 --> Exp10
  id : CAT_Exp14 --> Exp9
  id : CAT_Exp14 --> Exp8
  id : CAT_Exp14 --> Exp7
  id : CAT_Exp14 --> Exp6
  id : CAT_Exp14 --> Exp5
  id : CAT_Exp14 --> Exp4
  id : CAT_Exp14 --> Exp3
  id : CAT_Exp14 --> Exp
  id : CAT_Exp14 --> Exp2
  (:[]) : CAT_Exp14 --> [Exp2]
  Especial : CAT_Exp14 --> Constant_expression
  InitExpr : CAT_Exp14 --> Initz
  (AnInit).(InitExpr) : CAT_Exp14 --> Initializers
  id : CAT_Exp15 --> Exp14
  id : CAT_Exp15 --> Exp13
  id : CAT_Exp15 --> Exp12
  id : CAT_Exp15 --> Exp11
  id : CAT_Exp15 --> Exp10
  id : CAT_Exp15 --> Exp9
  id : CAT_Exp15 --> Exp8
  id : CAT_Exp15 --> Exp7
  id : CAT_Exp15 --> Exp6
  id : CAT_Exp15 --> Exp5
  id : CAT_Exp15 --> Exp4
  id : CAT_Exp15 --> Exp3
  id : CAT_Exp15 --> Exp
  id : CAT_Exp15 --> Exp2
  (:[]) : CAT_Exp15 --> [Exp2]
  Especial : CAT_Exp15 --> Constant_expression
  InitExpr : CAT_Exp15 --> Initz
  (AnInit).(InitExpr) : CAT_Exp15 --> Initializers
  id : CAT_Exp16 --> Exp15
  id : CAT_Exp16 --> Exp14
  id : CAT_Exp16 --> Exp13
  id : CAT_Exp16 --> Exp12
  id : CAT_Exp16 --> Exp11
  id : CAT_Exp16 --> Exp10
  id : CAT_Exp16 --> Exp9
  id : CAT_Exp16 --> Exp8
  id : CAT_Exp16 --> Exp7
  id : CAT_Exp16 --> Exp6
  id : CAT_Exp16 --> Exp5
  id : CAT_Exp16 --> Exp4
  id : CAT_Exp16 --> Exp3
  id : CAT_Exp16 --> Exp
  id : CAT_Exp16 --> Exp2
  (:[]) : CAT_Exp16 --> [Exp2]
  Especial : CAT_Exp16 --> Constant_expression
  InitExpr : CAT_Exp16 --> Initz
  (AnInit).(InitExpr) : CAT_Exp16 --> Initializers
  id : CAT_Exp17 --> Exp16
  id : CAT_Exp17 --> Exp15
  id : CAT_Exp17 --> Exp14
  id : CAT_Exp17 --> Exp13
  id : CAT_Exp17 --> Exp12
  id : CAT_Exp17 --> Exp11
  id : CAT_Exp17 --> Exp10
  id : CAT_Exp17 --> Exp9
  id : CAT_Exp17 --> Exp8
  id : CAT_Exp17 --> Exp7
  id : CAT_Exp17 --> Exp6
  id : CAT_Exp17 --> Exp5
  id : CAT_Exp17 --> Exp4
  id : CAT_Exp17 --> Exp3
  id : CAT_Exp17 --> Exp
  id : CAT_Exp17 --> Exp2
  (:[]) : CAT_Exp17 --> [Exp2]
  Especial : CAT_Exp17 --> Constant_expression
  InitExpr : CAT_Exp17 --> Initz
  (AnInit).(InitExpr) : CAT_Exp17 --> Initializers
  id : CAT_Exp2 --> Exp
  (:[]) : CAT_Exp2 --> [Exp2]
  InitExpr : CAT_Exp2 --> Initz
  (AnInit).(InitExpr) : CAT_Exp2 --> Initializers
  id : CAT_Exp3 --> Exp
  id : CAT_Exp3 --> Exp2
  (:[]) : CAT_Exp3 --> [Exp2]
  Especial : CAT_Exp3 --> Constant_expression
  InitExpr : CAT_Exp3 --> Initz
  (AnInit).(InitExpr) : CAT_Exp3 --> Initializers
  id : CAT_Exp4 --> Exp3
  id : CAT_Exp4 --> Exp
  id : CAT_Exp4 --> Exp2
  (:[]) : CAT_Exp4 --> [Exp2]
  Especial : CAT_Exp4 --> Constant_expression
  InitExpr : CAT_Exp4 --> Initz
  (AnInit).(InitExpr) : CAT_Exp4 --> Initializers
  id : CAT_Exp5 --> Exp4
  id : CAT_Exp5 --> Exp3
  id : CAT_Exp5 --> Exp
  id : CAT_Exp5 --> Exp2
  (:[]) : CAT_Exp5 --> [Exp2]
  Especial : CAT_Exp5 --> Constant_expression
  InitExpr : CAT_Exp5 --> Initz
  (AnInit).(InitExpr) : CAT_Exp5 --> Initializers
  id : CAT_Exp6 --> Exp5
  id : CAT_Exp6 --> Exp4
  id : CAT_Exp6 --> Exp3
  id : CAT_Exp6 --> Exp
  id : CAT_Exp6 --> Exp2
  (:[]) : CAT_Exp6 --> [Exp2]
  Especial : CAT_Exp6 --> Constant_expression
  InitExpr : CAT_Exp6 --> Initz
  (AnInit).(InitExpr) : CAT_Exp6 --> Initializers
  id : CAT_Exp7 --> Exp6
  id : CAT_Exp7 --> Exp5
  id : CAT_Exp7 --> Exp4
  id : CAT_Exp7 --> Exp3
  id : CAT_Exp7 --> Exp
  id : CAT_Exp7 --> Exp2
  (:[]) : CAT_Exp7 --> [Exp2]
  Especial : CAT_Exp7 --> Constant_expression
  InitExpr : CAT_Exp7 --> Initz
  (AnInit).(InitExpr) : CAT_Exp7 --> Initializers
  id : CAT_Exp8 --> Exp7
  id : CAT_Exp8 --> Exp6
  id : CAT_Exp8 --> Exp5
  id : CAT_Exp8 --> Exp4
  id : CAT_Exp8 --> Exp3
  id : CAT_Exp8 --> Exp
  id : CAT_Exp8 --> Exp2
  (:[]) : CAT_Exp8 --> [Exp2]
  Especial : CAT_Exp8 --> Constant_expression
  InitExpr : CAT_Exp8 --> Initz
  (AnInit).(InitExpr) : CAT_Exp8 --> Initializers
  id : CAT_Exp9 --> Exp8
  id : CAT_Exp9 --> Exp7
  id : CAT_Exp9 --> Exp6
  id : CAT_Exp9 --> Exp5
  id : CAT_Exp9 --> Exp4
  id : CAT_Exp9 --> Exp3
  id : CAT_Exp9 --> Exp
  id : CAT_Exp9 --> Exp2
  (:[]) : CAT_Exp9 --> [Exp2]
  Especial : CAT_Exp9 --> Constant_expression
  InitExpr : CAT_Exp9 --> Initz
  (AnInit).(InitExpr) : CAT_Exp9 --> Initializers
  ExprS : CAT_Expression_stm --> Stm
  ((:[])).(ExprS) : CAT_Expression_stm --> [Stm]
  (:[]) : CAT_External_declaration --> [External_declaration]
  (Progr).((:[])) : CAT_External_declaration --> Program
  Afunc : CAT_Function_def --> External_declaration
  ((:[])).(Afunc) : CAT_Function_def --> [External_declaration]
  ((Progr).((:[]))).(Afunc) : CAT_Function_def --> Program
  Ehexalong : CAT_HexLong --> Constant
  (Econst).(Ehexalong) : CAT_HexLong --> Exp17
  (Econst).(Ehexalong) : CAT_HexLong --> Exp16
  (Econst).(Ehexalong) : CAT_HexLong --> Exp15
  (Econst).(Ehexalong) : CAT_HexLong --> Exp14
  (Econst).(Ehexalong) : CAT_HexLong --> Exp13
  (Econst).(Ehexalong) : CAT_HexLong --> Exp12
  (Econst).(Ehexalong) : CAT_HexLong --> Exp11
  (Econst).(Ehexalong) : CAT_HexLong --> Exp10
  (Econst).(Ehexalong) : CAT_HexLong --> Exp9
  (Econst).(Ehexalong) : CAT_HexLong --> Exp8
  (Econst).(Ehexalong) : CAT_HexLong --> Exp7
  (Econst).(Ehexalong) : CAT_HexLong --> Exp6
  (Econst).(Ehexalong) : CAT_HexLong --> Exp5
  (Econst).(Ehexalong) : CAT_HexLong --> Exp4
  (Econst).(Ehexalong) : CAT_HexLong --> Exp3
  (Econst).(Ehexalong) : CAT_HexLong --> Exp
  (Econst).(Ehexalong) : CAT_HexLong --> Exp2
  (((:[])).(Econst)).(Ehexalong) : CAT_HexLong --> [Exp2]
  ((Especial).(Econst)).(Ehexalong) : CAT_HexLong --> Constant_expression
  ((InitExpr).(Econst)).(Ehexalong) : CAT_HexLong --> Initz
  (((AnInit).(InitExpr)).(Econst)).(Ehexalong) : CAT_HexLong --> Initializers
  Ehexaunslong : CAT_HexUnsLong --> Constant
  (Econst).(Ehexaunslong) : CAT_HexUnsLong --> Exp17
  (Econst).(Ehexaunslong) : CAT_HexUnsLong --> Exp16
  (Econst).(Ehexaunslong) : CAT_HexUnsLong --> Exp15
  (Econst).(Ehexaunslong) : CAT_HexUnsLong --> Exp14
  (Econst).(Ehexaunslong) : CAT_HexUnsLong --> Exp13
  (Econst).(Ehexaunslong) : CAT_HexUnsLong --> Exp12
  (Econst).(Ehexaunslong) : CAT_HexUnsLong --> Exp11
  (Econst).(Ehexaunslong) : CAT_HexUnsLong --> Exp10
  (Econst).(Ehexaunslong) : CAT_HexUnsLong --> Exp9
  (Econst).(Ehexaunslong) : CAT_HexUnsLong --> Exp8
  (Econst).(Ehexaunslong) : CAT_HexUnsLong --> Exp7
  (Econst).(Ehexaunslong) : CAT_HexUnsLong --> Exp6
  (Econst).(Ehexaunslong) : CAT_HexUnsLong --> Exp5
  (Econst).(Ehexaunslong) : CAT_HexUnsLong --> Exp4
  (Econst).(Ehexaunslong) : CAT_HexUnsLong --> Exp3
  (Econst).(Ehexaunslong) : CAT_HexUnsLong --> Exp
  (Econst).(Ehexaunslong) : CAT_HexUnsLong --> Exp2
  (((:[])).(Econst)).(Ehexaunslong) : CAT_HexUnsLong --> [Exp2]
  ((Especial).(Econst)).(Ehexaunslong) : CAT_HexUnsLong --> Constant_expression
  ((InitExpr).(Econst)).(Ehexaunslong) : CAT_HexUnsLong --> Initz
  (((AnInit).(InitExpr)).(Econst)).(Ehexaunslong) : CAT_HexUnsLong --> Initializers
  Ehexaunsign : CAT_HexUnsigned --> Constant
  (Econst).(Ehexaunsign) : CAT_HexUnsigned --> Exp17
  (Econst).(Ehexaunsign) : CAT_HexUnsigned --> Exp16
  (Econst).(Ehexaunsign) : CAT_HexUnsigned --> Exp15
  (Econst).(Ehexaunsign) : CAT_HexUnsigned --> Exp14
  (Econst).(Ehexaunsign) : CAT_HexUnsigned --> Exp13
  (Econst).(Ehexaunsign) : CAT_HexUnsigned --> Exp12
  (Econst).(Ehexaunsign) : CAT_HexUnsigned --> Exp11
  (Econst).(Ehexaunsign) : CAT_HexUnsigned --> Exp10
  (Econst).(Ehexaunsign) : CAT_HexUnsigned --> Exp9
  (Econst).(Ehexaunsign) : CAT_HexUnsigned --> Exp8
  (Econst).(Ehexaunsign) : CAT_HexUnsigned --> Exp7
  (Econst).(Ehexaunsign) : CAT_HexUnsigned --> Exp6
  (Econst).(Ehexaunsign) : CAT_HexUnsigned --> Exp5
  (Econst).(Ehexaunsign) : CAT_HexUnsigned --> Exp4
  (Econst).(Ehexaunsign) : CAT_HexUnsigned --> Exp3
  (Econst).(Ehexaunsign) : CAT_HexUnsigned --> Exp
  (Econst).(Ehexaunsign) : CAT_HexUnsigned --> Exp2
  (((:[])).(Econst)).(Ehexaunsign) : CAT_HexUnsigned --> [Exp2]
  ((Especial).(Econst)).(Ehexaunsign) : CAT_HexUnsigned --> Constant_expression
  ((InitExpr).(Econst)).(Ehexaunsign) : CAT_HexUnsigned --> Initz
  (((AnInit).(InitExpr)).(Econst)).(Ehexaunsign) : CAT_HexUnsigned --> Initializers
  Ehexadec : CAT_Hexadecimal --> Constant
  (Econst).(Ehexadec) : CAT_Hexadecimal --> Exp17
  (Econst).(Ehexadec) : CAT_Hexadecimal --> Exp16
  (Econst).(Ehexadec) : CAT_Hexadecimal --> Exp15
  (Econst).(Ehexadec) : CAT_Hexadecimal --> Exp14
  (Econst).(Ehexadec) : CAT_Hexadecimal --> Exp13
  (Econst).(Ehexadec) : CAT_Hexadecimal --> Exp12
  (Econst).(Ehexadec) : CAT_Hexadecimal --> Exp11
  (Econst).(Ehexadec) : CAT_Hexadecimal --> Exp10
  (Econst).(Ehexadec) : CAT_Hexadecimal --> Exp9
  (Econst).(Ehexadec) : CAT_Hexadecimal --> Exp8
  (Econst).(Ehexadec) : CAT_Hexadecimal --> Exp7
  (Econst).(Ehexadec) : CAT_Hexadecimal --> Exp6
  (Econst).(Ehexadec) : CAT_Hexadecimal --> Exp5
  (Econst).(Ehexadec) : CAT_Hexadecimal --> Exp4
  (Econst).(Ehexadec) : CAT_Hexadecimal --> Exp3
  (Econst).(Ehexadec) : CAT_Hexadecimal --> Exp
  (Econst).(Ehexadec) : CAT_Hexadecimal --> Exp2
  (((:[])).(Econst)).(Ehexadec) : CAT_Hexadecimal --> [Exp2]
  ((Especial).(Econst)).(Ehexadec) : CAT_Hexadecimal --> Constant_expression
  ((InitExpr).(Econst)).(Ehexadec) : CAT_Hexadecimal --> Initz
  (((AnInit).(InitExpr)).(Econst)).(Ehexadec) : CAT_Hexadecimal --> Initializers
  (:[]) : CAT_Ident --> [Ident]
  Evar : CAT_Ident --> Exp
  Evar : CAT_Ident --> Exp10
  Evar : CAT_Ident --> Exp11
  Evar : CAT_Ident --> Exp12
  Evar : CAT_Ident --> Exp13
  Evar : CAT_Ident --> Exp14
  Evar : CAT_Ident --> Exp15
  Evar : CAT_Ident --> Exp16
  Evar : CAT_Ident --> Exp17
  Evar : CAT_Ident --> Exp2
  Evar : CAT_Ident --> Exp3
  Evar : CAT_Ident --> Exp4
  Evar : CAT_Ident --> Exp5
  Evar : CAT_Ident --> Exp6
  Evar : CAT_Ident --> Exp7
  Evar : CAT_Ident --> Exp8
  Evar : CAT_Ident --> Exp9
  Name : CAT_Ident --> Direct_declarator
  Plain : CAT_Ident --> Enumerator
  ((:[])).(Evar) : CAT_Ident --> [Exp2]
  ((:[])).(Plain) : CAT_Ident --> [Enumerator]
  (Especial).(Evar) : CAT_Ident --> Constant_expression
  (InitExpr).(Evar) : CAT_Ident --> Initz
  (NoPointer).(Name) : CAT_Ident --> Declarator
  ((AnInit).(InitExpr)).(Evar) : CAT_Ident --> Initializers
  ((Decl).(NoPointer)).(Name) : CAT_Ident --> Struct_declarator
  ((OnlyDecl).(NoPointer)).(Name) : CAT_Ident --> Init_declarator
  ((((:[])).(Decl)).(NoPointer)).(Name) : CAT_Ident --> [Struct_declarator]
  ((((:[])).(OnlyDecl)).(NoPointer)).(Name) : CAT_Ident --> [Init_declarator]
  (:[]) : CAT_Init_declarator --> [Init_declarator]
  AnInit : CAT_Initz --> Initializers
  Eint : CAT_Integer --> Constant
  (Econst).(Eint) : CAT_Integer --> Exp17
  (Econst).(Eint) : CAT_Integer --> Exp16
  (Econst).(Eint) : CAT_Integer --> Exp15
  (Econst).(Eint) : CAT_Integer --> Exp14
  (Econst).(Eint) : CAT_Integer --> Exp13
  (Econst).(Eint) : CAT_Integer --> Exp12
  (Econst).(Eint) : CAT_Integer --> Exp11
  (Econst).(Eint) : CAT_Integer --> Exp10
  (Econst).(Eint) : CAT_Integer --> Exp9
  (Econst).(Eint) : CAT_Integer --> Exp8
  (Econst).(Eint) : CAT_Integer --> Exp7
  (Econst).(Eint) : CAT_Integer --> Exp6
  (Econst).(Eint) : CAT_Integer --> Exp5
  (Econst).(Eint) : CAT_Integer --> Exp4
  (Econst).(Eint) : CAT_Integer --> Exp3
  (Econst).(Eint) : CAT_Integer --> Exp
  (Econst).(Eint) : CAT_Integer --> Exp2
  (((:[])).(Econst)).(Eint) : CAT_Integer --> [Exp2]
  ((Especial).(Econst)).(Eint) : CAT_Integer --> Constant_expression
  ((InitExpr).(Econst)).(Eint) : CAT_Integer --> Initz
  (((AnInit).(InitExpr)).(Econst)).(Eint) : CAT_Integer --> Initializers
  IterS : CAT_Iter_stm --> Stm
  ((:[])).(IterS) : CAT_Iter_stm --> [Stm]
  JumpS : CAT_Jump_stm --> Stm
  ((:[])).(JumpS) : CAT_Jump_stm --> [Stm]
  LabelS : CAT_Labeled_stm --> Stm
  ((:[])).(LabelS) : CAT_Labeled_stm --> [Stm]
  Elong : CAT_Long --> Constant
  (Econst).(Elong) : CAT_Long --> Exp17
  (Econst).(Elong) : CAT_Long --> Exp16
  (Econst).(Elong) : CAT_Long --> Exp15
  (Econst).(Elong) : CAT_Long --> Exp14
  (Econst).(Elong) : CAT_Long --> Exp13
  (Econst).(Elong) : CAT_Long --> Exp12
  (Econst).(Elong) : CAT_Long --> Exp11
  (Econst).(Elong) : CAT_Long --> Exp10
  (Econst).(Elong) : CAT_Long --> Exp9
  (Econst).(Elong) : CAT_Long --> Exp8
  (Econst).(Elong) : CAT_Long --> Exp7
  (Econst).(Elong) : CAT_Long --> Exp6
  (Econst).(Elong) : CAT_Long --> Exp5
  (Econst).(Elong) : CAT_Long --> Exp4
  (Econst).(Elong) : CAT_Long --> Exp3
  (Econst).(Elong) : CAT_Long --> Exp
  (Econst).(Elong) : CAT_Long --> Exp2
  (((:[])).(Econst)).(Elong) : CAT_Long --> [Exp2]
  ((Especial).(Econst)).(Elong) : CAT_Long --> Constant_expression
  ((InitExpr).(Econst)).(Elong) : CAT_Long --> Initz
  (((AnInit).(InitExpr)).(Econst)).(Elong) : CAT_Long --> Initializers
  Eoctal : CAT_Octal --> Constant
  (Econst).(Eoctal) : CAT_Octal --> Exp17
  (Econst).(Eoctal) : CAT_Octal --> Exp16
  (Econst).(Eoctal) : CAT_Octal --> Exp15
  (Econst).(Eoctal) : CAT_Octal --> Exp14
  (Econst).(Eoctal) : CAT_Octal --> Exp13
  (Econst).(Eoctal) : CAT_Octal --> Exp12
  (Econst).(Eoctal) : CAT_Octal --> Exp11
  (Econst).(Eoctal) : CAT_Octal --> Exp10
  (Econst).(Eoctal) : CAT_Octal --> Exp9
  (Econst).(Eoctal) : CAT_Octal --> Exp8
  (Econst).(Eoctal) : CAT_Octal --> Exp7
  (Econst).(Eoctal) : CAT_Octal --> Exp6
  (Econst).(Eoctal) : CAT_Octal --> Exp5
  (Econst).(Eoctal) : CAT_Octal --> Exp4
  (Econst).(Eoctal) : CAT_Octal --> Exp3
  (Econst).(Eoctal) : CAT_Octal --> Exp
  (Econst).(Eoctal) : CAT_Octal --> Exp2
  (((:[])).(Econst)).(Eoctal) : CAT_Octal --> [Exp2]
  ((Especial).(Econst)).(Eoctal) : CAT_Octal --> Constant_expression
  ((InitExpr).(Econst)).(Eoctal) : CAT_Octal --> Initz
  (((AnInit).(InitExpr)).(Econst)).(Eoctal) : CAT_Octal --> Initializers
  Eoctallong : CAT_OctalLong --> Constant
  (Econst).(Eoctallong) : CAT_OctalLong --> Exp17
  (Econst).(Eoctallong) : CAT_OctalLong --> Exp16
  (Econst).(Eoctallong) : CAT_OctalLong --> Exp15
  (Econst).(Eoctallong) : CAT_OctalLong --> Exp14
  (Econst).(Eoctallong) : CAT_OctalLong --> Exp13
  (Econst).(Eoctallong) : CAT_OctalLong --> Exp12
  (Econst).(Eoctallong) : CAT_OctalLong --> Exp11
  (Econst).(Eoctallong) : CAT_OctalLong --> Exp10
  (Econst).(Eoctallong) : CAT_OctalLong --> Exp9
  (Econst).(Eoctallong) : CAT_OctalLong --> Exp8
  (Econst).(Eoctallong) : CAT_OctalLong --> Exp7
  (Econst).(Eoctallong) : CAT_OctalLong --> Exp6
  (Econst).(Eoctallong) : CAT_OctalLong --> Exp5
  (Econst).(Eoctallong) : CAT_OctalLong --> Exp4
  (Econst).(Eoctallong) : CAT_OctalLong --> Exp3
  (Econst).(Eoctallong) : CAT_OctalLong --> Exp
  (Econst).(Eoctallong) : CAT_OctalLong --> Exp2
  (((:[])).(Econst)).(Eoctallong) : CAT_OctalLong --> [Exp2]
  ((Especial).(Econst)).(Eoctallong) : CAT_OctalLong --> Constant_expression
  ((InitExpr).(Econst)).(Eoctallong) : CAT_OctalLong --> Initz
  (((AnInit).(InitExpr)).(Econst)).(Eoctallong) : CAT_OctalLong --> Initializers
  Eoctalunslong : CAT_OctalUnsLong --> Constant
  (Econst).(Eoctalunslong) : CAT_OctalUnsLong --> Exp17
  (Econst).(Eoctalunslong) : CAT_OctalUnsLong --> Exp16
  (Econst).(Eoctalunslong) : CAT_OctalUnsLong --> Exp15
  (Econst).(Eoctalunslong) : CAT_OctalUnsLong --> Exp14
  (Econst).(Eoctalunslong) : CAT_OctalUnsLong --> Exp13
  (Econst).(Eoctalunslong) : CAT_OctalUnsLong --> Exp12
  (Econst).(Eoctalunslong) : CAT_OctalUnsLong --> Exp11
  (Econst).(Eoctalunslong) : CAT_OctalUnsLong --> Exp10
  (Econst).(Eoctalunslong) : CAT_OctalUnsLong --> Exp9
  (Econst).(Eoctalunslong) : CAT_OctalUnsLong --> Exp8
  (Econst).(Eoctalunslong) : CAT_OctalUnsLong --> Exp7
  (Econst).(Eoctalunslong) : CAT_OctalUnsLong --> Exp6
  (Econst).(Eoctalunslong) : CAT_OctalUnsLong --> Exp5
  (Econst).(Eoctalunslong) : CAT_OctalUnsLong --> Exp4
  (Econst).(Eoctalunslong) : CAT_OctalUnsLong --> Exp3
  (Econst).(Eoctalunslong) : CAT_OctalUnsLong --> Exp
  (Econst).(Eoctalunslong) : CAT_OctalUnsLong --> Exp2
  (((:[])).(Econst)).(Eoctalunslong) : CAT_OctalUnsLong --> [Exp2]
  ((Especial).(Econst)).(Eoctalunslong) : CAT_OctalUnsLong --> Constant_expression
  ((InitExpr).(Econst)).(Eoctalunslong) : CAT_OctalUnsLong --> Initz
  (((AnInit).(InitExpr)).(Econst)).(Eoctalunslong) : CAT_OctalUnsLong --> Initializers
  Eoctalunsign : CAT_OctalUnsigned --> Constant
  (Econst).(Eoctalunsign) : CAT_OctalUnsigned --> Exp17
  (Econst).(Eoctalunsign) : CAT_OctalUnsigned --> Exp16
  (Econst).(Eoctalunsign) : CAT_OctalUnsigned --> Exp15
  (Econst).(Eoctalunsign) : CAT_OctalUnsigned --> Exp14
  (Econst).(Eoctalunsign) : CAT_OctalUnsigned --> Exp13
  (Econst).(Eoctalunsign) : CAT_OctalUnsigned --> Exp12
  (Econst).(Eoctalunsign) : CAT_OctalUnsigned --> Exp11
  (Econst).(Eoctalunsign) : CAT_OctalUnsigned --> Exp10
  (Econst).(Eoctalunsign) : CAT_OctalUnsigned --> Exp9
  (Econst).(Eoctalunsign) : CAT_OctalUnsigned --> Exp8
  (Econst).(Eoctalunsign) : CAT_OctalUnsigned --> Exp7
  (Econst).(Eoctalunsign) : CAT_OctalUnsigned --> Exp6
  (Econst).(Eoctalunsign) : CAT_OctalUnsigned --> Exp5
  (Econst).(Eoctalunsign) : CAT_OctalUnsigned --> Exp4
  (Econst).(Eoctalunsign) : CAT_OctalUnsigned --> Exp3
  (Econst).(Eoctalunsign) : CAT_OctalUnsigned --> Exp
  (Econst).(Eoctalunsign) : CAT_OctalUnsigned --> Exp2
  (((:[])).(Econst)).(Eoctalunsign) : CAT_OctalUnsigned --> [Exp2]
  ((Especial).(Econst)).(Eoctalunsign) : CAT_OctalUnsigned --> Constant_expression
  ((InitExpr).(Econst)).(Eoctalunsign) : CAT_OctalUnsigned --> Initz
  (((AnInit).(InitExpr)).(Econst)).(Eoctalunsign) : CAT_OctalUnsigned --> Initializers
  ParamDec : CAT_Parameter_declaration --> Parameter_declarations
  (AllSpec).(ParamDec) : CAT_Parameter_declaration --> Parameter_type
  AllSpec : CAT_Parameter_declarations --> Parameter_type
  PointerStart : CAT_Pointer --> Abstract_declarator
  SelS : CAT_Selection_stm --> Stm
  ((:[])).(SelS) : CAT_Selection_stm --> [Stm]
  (:[]) : CAT_Spec_qual --> [Spec_qual]
  (PlainType).((:[])) : CAT_Spec_qual --> Type_name
  (:[]) : CAT_Stm --> [Stm]
  Storage : CAT_Storage_class_specifier --> Declaration_specifier
  ((:[])).(Storage) : CAT_Storage_class_specifier --> [Declaration_specifier]
  ((OnlyType).((:[]))).(Storage) : CAT_Storage_class_specifier --> Parameter_declaration
  (((ParamDec).(OnlyType)).((:[]))).(Storage) : CAT_Storage_class_specifier --> Parameter_declarations
  ((((AllSpec).(ParamDec)).(OnlyType)).((:[]))).(Storage) : CAT_Storage_class_specifier --> Parameter_type
  Estring : CAT_String --> Exp17
  Estring : CAT_String --> Exp16
  Estring : CAT_String --> Exp15
  Estring : CAT_String --> Exp14
  Estring : CAT_String --> Exp13
  Estring : CAT_String --> Exp12
  Estring : CAT_String --> Exp11
  Estring : CAT_String --> Exp10
  Estring : CAT_String --> Exp9
  Estring : CAT_String --> Exp8
  Estring : CAT_String --> Exp7
  Estring : CAT_String --> Exp6
  Estring : CAT_String --> Exp5
  Estring : CAT_String --> Exp4
  Estring : CAT_String --> Exp3
  Estring : CAT_String --> Exp
  Estring : CAT_String --> Exp2
  ((:[])).(Estring) : CAT_String --> [Exp2]
  (Especial).(Estring) : CAT_String --> Constant_expression
  (InitExpr).(Estring) : CAT_String --> Initz
  ((AnInit).(InitExpr)).(Estring) : CAT_String --> Initializers
  (:[]) : CAT_Struct_dec --> [Struct_dec]
  (:[]) : CAT_Struct_declarator --> [Struct_declarator]
  Tstruct : CAT_Struct_or_union_spec --> Type_specifier
  (Type).(Tstruct) : CAT_Struct_or_union_spec --> Declaration_specifier
  (TypeSpec).(Tstruct) : CAT_Struct_or_union_spec --> Spec_qual
  (((:[])).(Type)).(Tstruct) : CAT_Struct_or_union_spec --> [Declaration_specifier]
  (((:[])).(TypeSpec)).(Tstruct) : CAT_Struct_or_union_spec --> [Spec_qual]
  (((OnlyType).((:[]))).(Type)).(Tstruct) : CAT_Struct_or_union_spec --> Parameter_declaration
  (((PlainType).((:[]))).(TypeSpec)).(Tstruct) : CAT_Struct_or_union_spec --> Type_name
  ((((ParamDec).(OnlyType)).((:[]))).(Type)).(Tstruct) : CAT_Struct_or_union_spec --> Parameter_declarations
  (((((AllSpec).(ParamDec)).(OnlyType)).((:[]))).(Type)).(Tstruct) : CAT_Struct_or_union_spec --> Parameter_type
  (:[]) : CAT_Type_qualifier --> [Type_qualifier]
  QualSpec : CAT_Type_qualifier --> Spec_qual
  SpecProp : CAT_Type_qualifier --> Declaration_specifier
  ((:[])).(QualSpec) : CAT_Type_qualifier --> [Spec_qual]
  ((:[])).(SpecProp) : CAT_Type_qualifier --> [Declaration_specifier]
  ((OnlyType).((:[]))).(SpecProp) : CAT_Type_qualifier --> Parameter_declaration
  ((PlainType).((:[]))).(QualSpec) : CAT_Type_qualifier --> Type_name
  (((ParamDec).(OnlyType)).((:[]))).(SpecProp) : CAT_Type_qualifier --> Parameter_declarations
  ((((AllSpec).(ParamDec)).(OnlyType)).((:[]))).(SpecProp) : CAT_Type_qualifier --> Parameter_type
  Type : CAT_Type_specifier --> Declaration_specifier
  TypeSpec : CAT_Type_specifier --> Spec_qual
  ((:[])).(Type) : CAT_Type_specifier --> [Declaration_specifier]
  ((:[])).(TypeSpec) : CAT_Type_specifier --> [Spec_qual]
  ((OnlyType).((:[]))).(Type) : CAT_Type_specifier --> Parameter_declaration
  ((PlainType).((:[]))).(TypeSpec) : CAT_Type_specifier --> Type_name
  (((ParamDec).(OnlyType)).((:[]))).(Type) : CAT_Type_specifier --> Parameter_declarations
  ((((AllSpec).(ParamDec)).(OnlyType)).((:[]))).(Type) : CAT_Type_specifier --> Parameter_type
  Eunsigned : CAT_Unsigned --> Constant
  (Econst).(Eunsigned) : CAT_Unsigned --> Exp17
  (Econst).(Eunsigned) : CAT_Unsigned --> Exp16
  (Econst).(Eunsigned) : CAT_Unsigned --> Exp15
  (Econst).(Eunsigned) : CAT_Unsigned --> Exp14
  (Econst).(Eunsigned) : CAT_Unsigned --> Exp13
  (Econst).(Eunsigned) : CAT_Unsigned --> Exp12
  (Econst).(Eunsigned) : CAT_Unsigned --> Exp11
  (Econst).(Eunsigned) : CAT_Unsigned --> Exp10
  (Econst).(Eunsigned) : CAT_Unsigned --> Exp9
  (Econst).(Eunsigned) : CAT_Unsigned --> Exp8
  (Econst).(Eunsigned) : CAT_Unsigned --> Exp7
  (Econst).(Eunsigned) : CAT_Unsigned --> Exp6
  (Econst).(Eunsigned) : CAT_Unsigned --> Exp5
  (Econst).(Eunsigned) : CAT_Unsigned --> Exp4
  (Econst).(Eunsigned) : CAT_Unsigned --> Exp3
  (Econst).(Eunsigned) : CAT_Unsigned --> Exp
  (Econst).(Eunsigned) : CAT_Unsigned --> Exp2
  (((:[])).(Econst)).(Eunsigned) : CAT_Unsigned --> [Exp2]
  ((Especial).(Econst)).(Eunsigned) : CAT_Unsigned --> Constant_expression
  ((InitExpr).(Econst)).(Eunsigned) : CAT_Unsigned --> Initz
  (((AnInit).(InitExpr)).(Econst)).(Eunsigned) : CAT_Unsigned --> Initializers
  Eunsignlong : CAT_UnsignedLong --> Constant
  (Econst).(Eunsignlong) : CAT_UnsignedLong --> Exp17
  (Econst).(Eunsignlong) : CAT_UnsignedLong --> Exp16
  (Econst).(Eunsignlong) : CAT_UnsignedLong --> Exp15
  (Econst).(Eunsignlong) : CAT_UnsignedLong --> Exp14
  (Econst).(Eunsignlong) : CAT_UnsignedLong --> Exp13
  (Econst).(Eunsignlong) : CAT_UnsignedLong --> Exp12
  (Econst).(Eunsignlong) : CAT_UnsignedLong --> Exp11
  (Econst).(Eunsignlong) : CAT_UnsignedLong --> Exp10
  (Econst).(Eunsignlong) : CAT_UnsignedLong --> Exp9
  (Econst).(Eunsignlong) : CAT_UnsignedLong --> Exp8
  (Econst).(Eunsignlong) : CAT_UnsignedLong --> Exp7
  (Econst).(Eunsignlong) : CAT_UnsignedLong --> Exp6
  (Econst).(Eunsignlong) : CAT_UnsignedLong --> Exp5
  (Econst).(Eunsignlong) : CAT_UnsignedLong --> Exp4
  (Econst).(Eunsignlong) : CAT_UnsignedLong --> Exp3
  (Econst).(Eunsignlong) : CAT_UnsignedLong --> Exp
  (Econst).(Eunsignlong) : CAT_UnsignedLong --> Exp2
  (((:[])).(Econst)).(Eunsignlong) : CAT_UnsignedLong --> [Exp2]
  ((Especial).(Econst)).(Eunsignlong) : CAT_UnsignedLong --> Constant_expression
  ((InitExpr).(Econst)).(Eunsignlong) : CAT_UnsignedLong --> Initz
  (((AnInit).(InitExpr)).(Econst)).(Eunsignlong) : CAT_UnsignedLong --> Initializers
  OnlyType : CAT_Declaration_specifier_List --> Parameter_declaration
  (ParamDec).(OnlyType) : CAT_Declaration_specifier_List --> Parameter_declarations
  ((AllSpec).(ParamDec)).(OnlyType) : CAT_Declaration_specifier_List --> Parameter_type
  Progr : CAT_External_declaration_List --> Program
  PlainType : CAT_Spec_qual_List --> Type_name
  Logicalneg : TOK_33 --> Unary_operator
  AssignMod : TOK_3761 --> Assignment_op
  Address : TOK_38 --> Unary_operator
  AssignAnd : TOK_3861 --> Assignment_op
  Indirection : TOK_42 --> Unary_operator
  Point : TOK_42 --> Pointer
  PointerStart (Point) : TOK_42 --> Abstract_declarator
  AssignMul : TOK_4261 --> Assignment_op
  Plus : TOK_43 --> Unary_operator
  AssignAdd : TOK_4361 --> Assignment_op
  Negative : TOK_45 --> Unary_operator
  AssignSub : TOK_4561 --> Assignment_op
  AssignDiv : TOK_4761 --> Assignment_op
  SexprOne : TOK_59 --> Expression_stm
  ExprS (SexprOne) : TOK_59 --> Stm
  (:[]) (ExprS (SexprOne)) : TOK_59 --> [Stm]
  AssignLeft : TOK_606061 --> Assignment_op
  Assign : TOK_61 --> Assignment_op
  AssignRight : TOK_626261 --> Assignment_op
  Tname : TOK_Typedef_name --> Type_specifier
  Type (Tname) : TOK_Typedef_name --> Declaration_specifier
  TypeSpec (Tname) : TOK_Typedef_name --> Spec_qual
  (:[]) (Type (Tname)) : TOK_Typedef_name --> [Declaration_specifier]
  (:[]) (TypeSpec (Tname)) : TOK_Typedef_name --> [Spec_qual]
  OnlyType ((:[]) (Type (Tname))) : TOK_Typedef_name --> Parameter_declaration
  PlainType ((:[]) (TypeSpec (Tname))) : TOK_Typedef_name --> Type_name
  ParamDec (OnlyType ((:[]) (Type (Tname)))) : TOK_Typedef_name --> Parameter_declarations
  AllSpec (ParamDec (OnlyType ((:[]) (Type (Tname))))) : TOK_Typedef_name --> Parameter_type
  AssignXor : TOK_9461 --> Assignment_op
  LocalBlock : TOK_auto --> Storage_class_specifier
  Storage (LocalBlock) : TOK_auto --> Declaration_specifier
  (:[]) (Storage (LocalBlock)) : TOK_auto --> [Declaration_specifier]
  OnlyType ((:[]) (Storage (LocalBlock))) : TOK_auto --> Parameter_declaration
  ParamDec (OnlyType ((:[]) (Storage (LocalBlock)))) : TOK_auto --> Parameter_declarations
  AllSpec (ParamDec (OnlyType ((:[]) (Storage (LocalBlock))))) : TOK_auto --> Parameter_type
  Tchar : TOK_char --> Type_specifier
  Type (Tchar) : TOK_char --> Declaration_specifier
  TypeSpec (Tchar) : TOK_char --> Spec_qual
  (:[]) (Type (Tchar)) : TOK_char --> [Declaration_specifier]
  (:[]) (TypeSpec (Tchar)) : TOK_char --> [Spec_qual]
  OnlyType ((:[]) (Type (Tchar))) : TOK_char --> Parameter_declaration
  PlainType ((:[]) (TypeSpec (Tchar))) : TOK_char --> Type_name
  ParamDec (OnlyType ((:[]) (Type (Tchar)))) : TOK_char --> Parameter_declarations
  AllSpec (ParamDec (OnlyType ((:[]) (Type (Tchar))))) : TOK_char --> Parameter_type
  Const : TOK_const --> Type_qualifier
  (:[]) (Const) : TOK_const --> [Type_qualifier]
  QualSpec (Const) : TOK_const --> Spec_qual
  SpecProp (Const) : TOK_const --> Declaration_specifier
  (:[]) (QualSpec (Const)) : TOK_const --> [Spec_qual]
  (:[]) (SpecProp (Const)) : TOK_const --> [Declaration_specifier]
  OnlyType ((:[]) (SpecProp (Const))) : TOK_const --> Parameter_declaration
  PlainType ((:[]) (QualSpec (Const))) : TOK_const --> Type_name
  ParamDec (OnlyType ((:[]) (SpecProp (Const)))) : TOK_const --> Parameter_declarations
  AllSpec (ParamDec (OnlyType ((:[]) (SpecProp (Const))))) : TOK_const --> Parameter_type
  Tdouble : TOK_double --> Type_specifier
  Type (Tdouble) : TOK_double --> Declaration_specifier
  TypeSpec (Tdouble) : TOK_double --> Spec_qual
  (:[]) (Type (Tdouble)) : TOK_double --> [Declaration_specifier]
  (:[]) (TypeSpec (Tdouble)) : TOK_double --> [Spec_qual]
  OnlyType ((:[]) (Type (Tdouble))) : TOK_double --> Parameter_declaration
  PlainType ((:[]) (TypeSpec (Tdouble))) : TOK_double --> Type_name
  ParamDec (OnlyType ((:[]) (Type (Tdouble)))) : TOK_double --> Parameter_declarations
  AllSpec (ParamDec (OnlyType ((:[]) (Type (Tdouble))))) : TOK_double --> Parameter_type
  GlobalPrograms : TOK_extern --> Storage_class_specifier
  Storage (GlobalPrograms) : TOK_extern --> Declaration_specifier
  (:[]) (Storage (GlobalPrograms)) : TOK_extern --> [Declaration_specifier]
  OnlyType ((:[]) (Storage (GlobalPrograms))) : TOK_extern --> Parameter_declaration
  ParamDec (OnlyType ((:[]) (Storage (GlobalPrograms)))) : TOK_extern --> Parameter_declarations
  AllSpec (ParamDec (OnlyType ((:[]) (Storage (GlobalPrograms))))) : TOK_extern --> Parameter_type
  Tfloat : TOK_float --> Type_specifier
  Type (Tfloat) : TOK_float --> Declaration_specifier
  TypeSpec (Tfloat) : TOK_float --> Spec_qual
  (:[]) (Type (Tfloat)) : TOK_float --> [Declaration_specifier]
  (:[]) (TypeSpec (Tfloat)) : TOK_float --> [Spec_qual]
  OnlyType ((:[]) (Type (Tfloat))) : TOK_float --> Parameter_declaration
  PlainType ((:[]) (TypeSpec (Tfloat))) : TOK_float --> Type_name
  ParamDec (OnlyType ((:[]) (Type (Tfloat)))) : TOK_float --> Parameter_declarations
  AllSpec (ParamDec (OnlyType ((:[]) (Type (Tfloat))))) : TOK_float --> Parameter_type
  Tint : TOK_int --> Type_specifier
  Type (Tint) : TOK_int --> Declaration_specifier
  TypeSpec (Tint) : TOK_int --> Spec_qual
  (:[]) (Type (Tint)) : TOK_int --> [Declaration_specifier]
  (:[]) (TypeSpec (Tint)) : TOK_int --> [Spec_qual]
  OnlyType ((:[]) (Type (Tint))) : TOK_int --> Parameter_declaration
  PlainType ((:[]) (TypeSpec (Tint))) : TOK_int --> Type_name
  ParamDec (OnlyType ((:[]) (Type (Tint)))) : TOK_int --> Parameter_declarations
  AllSpec (ParamDec (OnlyType ((:[]) (Type (Tint))))) : TOK_int --> Parameter_type
  Tlong : TOK_long --> Type_specifier
  Type (Tlong) : TOK_long --> Declaration_specifier
  TypeSpec (Tlong) : TOK_long --> Spec_qual
  (:[]) (Type (Tlong)) : TOK_long --> [Declaration_specifier]
  (:[]) (TypeSpec (Tlong)) : TOK_long --> [Spec_qual]
  OnlyType ((:[]) (Type (Tlong))) : TOK_long --> Parameter_declaration
  PlainType ((:[]) (TypeSpec (Tlong))) : TOK_long --> Type_name
  ParamDec (OnlyType ((:[]) (Type (Tlong)))) : TOK_long --> Parameter_declarations
  AllSpec (ParamDec (OnlyType ((:[]) (Type (Tlong))))) : TOK_long --> Parameter_type
  LocalReg : TOK_register --> Storage_class_specifier
  Storage (LocalReg) : TOK_register --> Declaration_specifier
  (:[]) (Storage (LocalReg)) : TOK_register --> [Declaration_specifier]
  OnlyType ((:[]) (Storage (LocalReg))) : TOK_register --> Parameter_declaration
  ParamDec (OnlyType ((:[]) (Storage (LocalReg)))) : TOK_register --> Parameter_declarations
  AllSpec (ParamDec (OnlyType ((:[]) (Storage (LocalReg))))) : TOK_register --> Parameter_type
  Tshort : TOK_short --> Type_specifier
  Type (Tshort) : TOK_short --> Declaration_specifier
  TypeSpec (Tshort) : TOK_short --> Spec_qual
  (:[]) (Type (Tshort)) : TOK_short --> [Declaration_specifier]
  (:[]) (TypeSpec (Tshort)) : TOK_short --> [Spec_qual]
  OnlyType ((:[]) (Type (Tshort))) : TOK_short --> Parameter_declaration
  PlainType ((:[]) (TypeSpec (Tshort))) : TOK_short --> Type_name
  ParamDec (OnlyType ((:[]) (Type (Tshort)))) : TOK_short --> Parameter_declarations
  AllSpec (ParamDec (OnlyType ((:[]) (Type (Tshort))))) : TOK_short --> Parameter_type
  Tsigned : TOK_signed --> Type_specifier
  Type (Tsigned) : TOK_signed --> Declaration_specifier
  TypeSpec (Tsigned) : TOK_signed --> Spec_qual
  (:[]) (Type (Tsigned)) : TOK_signed --> [Declaration_specifier]
  (:[]) (TypeSpec (Tsigned)) : TOK_signed --> [Spec_qual]
  OnlyType ((:[]) (Type (Tsigned))) : TOK_signed --> Parameter_declaration
  PlainType ((:[]) (TypeSpec (Tsigned))) : TOK_signed --> Type_name
  ParamDec (OnlyType ((:[]) (Type (Tsigned)))) : TOK_signed --> Parameter_declarations
  AllSpec (ParamDec (OnlyType ((:[]) (Type (Tsigned))))) : TOK_signed --> Parameter_type
  LocalProgram : TOK_static --> Storage_class_specifier
  Storage (LocalProgram) : TOK_static --> Declaration_specifier
  (:[]) (Storage (LocalProgram)) : TOK_static --> [Declaration_specifier]
  OnlyType ((:[]) (Storage (LocalProgram))) : TOK_static --> Parameter_declaration
  ParamDec (OnlyType ((:[]) (Storage (LocalProgram)))) : TOK_static --> Parameter_declarations
  AllSpec (ParamDec (OnlyType ((:[]) (Storage (LocalProgram))))) : TOK_static --> Parameter_type
  Struct : TOK_struct --> Struct_or_union
  MyType : TOK_typedef --> Storage_class_specifier
  Storage (MyType) : TOK_typedef --> Declaration_specifier
  (:[]) (Storage (MyType)) : TOK_typedef --> [Declaration_specifier]
  OnlyType ((:[]) (Storage (MyType))) : TOK_typedef --> Parameter_declaration
  ParamDec (OnlyType ((:[]) (Storage (MyType)))) : TOK_typedef --> Parameter_declarations
  AllSpec (ParamDec (OnlyType ((:[]) (Storage (MyType))))) : TOK_typedef --> Parameter_type
  Union : TOK_union --> Struct_or_union
  Tunsigned : TOK_unsigned --> Type_specifier
  Type (Tunsigned) : TOK_unsigned --> Declaration_specifier
  TypeSpec (Tunsigned) : TOK_unsigned --> Spec_qual
  (:[]) (Type (Tunsigned)) : TOK_unsigned --> [Declaration_specifier]
  (:[]) (TypeSpec (Tunsigned)) : TOK_unsigned --> [Spec_qual]
  OnlyType ((:[]) (Type (Tunsigned))) : TOK_unsigned --> Parameter_declaration
  PlainType ((:[]) (TypeSpec (Tunsigned))) : TOK_unsigned --> Type_name
  ParamDec (OnlyType ((:[]) (Type (Tunsigned)))) : TOK_unsigned --> Parameter_declarations
  AllSpec (ParamDec (OnlyType ((:[]) (Type (Tunsigned))))) : TOK_unsigned --> Parameter_type
  Tvoid : TOK_void --> Type_specifier
  Type (Tvoid) : TOK_void --> Declaration_specifier
  TypeSpec (Tvoid) : TOK_void --> Spec_qual
  (:[]) (Type (Tvoid)) : TOK_void --> [Declaration_specifier]
  (:[]) (TypeSpec (Tvoid)) : TOK_void --> [Spec_qual]
  OnlyType ((:[]) (Type (Tvoid))) : TOK_void --> Parameter_declaration
  PlainType ((:[]) (TypeSpec (Tvoid))) : TOK_void --> Type_name
  ParamDec (OnlyType ((:[]) (Type (Tvoid)))) : TOK_void --> Parameter_declarations
  AllSpec (ParamDec (OnlyType ((:[]) (Type (Tvoid))))) : TOK_void --> Parameter_type
  NoOptim : TOK_volatile --> Type_qualifier
  (:[]) (NoOptim) : TOK_volatile --> [Type_qualifier]
  QualSpec (NoOptim) : TOK_volatile --> Spec_qual
  SpecProp (NoOptim) : TOK_volatile --> Declaration_specifier
  (:[]) (QualSpec (NoOptim)) : TOK_volatile --> [Spec_qual]
  (:[]) (SpecProp (NoOptim)) : TOK_volatile --> [Declaration_specifier]
  OnlyType ((:[]) (SpecProp (NoOptim))) : TOK_volatile --> Parameter_declaration
  PlainType ((:[]) (QualSpec (NoOptim))) : TOK_volatile --> Type_name
  ParamDec (OnlyType ((:[]) (SpecProp (NoOptim)))) : TOK_volatile --> Parameter_declarations
  AllSpec (ParamDec (OnlyType ((:[]) (SpecProp (NoOptim))))) : TOK_volatile --> Parameter_type
  AssignOr : TOK_12461 --> Assignment_op
  Complement : TOK_126 --> Unary_operator*/
	public static CatTag[] addition(CatTag[] a, CatTag[] b)
	{
		  CatTag[] result = Arrays.copyOf(a, a.length+b.length);
		  System.arraycopy(b, 0, result, a.length, b.length);
		  return result; 
	}
	/*public  ArrayList<Pair> multiplication(CatTag[] a, CatTag[] b)
	{
		  //Pair x;
		  ArrayList<Pair> result = new ArrayList<Pair>();
		  for(CatTag ai: a)
			  for(CatTag bi: b){
				  result.add(getCombine(true, ai, bi));
			  }
		  return result;
	}*/
	public Pair multiply(boolean p, CatTag[] a, CatTag[] b)
	{
		Pair result =  new Pair(new CatTag[]{}, new CatTag[]{});
		for(CatTag ai: a)
			  for(CatTag bi: b){
				  result.setFirst(addition(result.first,getCombine(p, ai, bi).first));
				  result.setSecond(addition(result.second,getCombine(p, ai, bi).second));
			  }
		return result;
		
	}
		public static void main(String args[])
		{
			CnfTablesc x = new CnfTablesc();
			//System.out.println(x.getDesc(CatTag.CAT_106));
			//System.out.println();
			Pair testingPair = x.tokenToCats (true , new Symbol(sym._SYMB_0));
			//System.out.println(testingPair.getPair());
			//System.out.println(x.getCombine (true, CatTag.TOK_OPEN_,CatTag.CAT_Initializers).getPair());
			CatTag[] a = {CatTag.CAT_0,CatTag.CAT_10};
			CatTag[] b = {CatTag.CAT_Compound_stm,CatTag.TOK_CLOS_};
			//for(CatTag c: addition(a,b))	
				//System.out.println(c);
			Pair result = x.multiply(true ,a ,b);
			System.out.println(result.getPair());
		} 
}