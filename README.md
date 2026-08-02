# Stop Re-Explaining Yourself

**CTE Workshop — WA-ACTE, August 2026**
Eric Ogden · high school CS teacher (AP CSP, AP CS A, Cybersecurity, Intro to CS, Esports Careers, Video Game Design) · 12 years as a software engineer before teaching.

Everything from the session is on this page. Nothing is gated. No signup.

---

## Do this first (5 minutes, tonight or tomorrow)

Take the Project you built with my fake syllabus and **swap in your real one.** That's it.
That's the whole first step. If you do nothing else from today, do that.

---

## The idea

You've been doing the same job for years and re-typing the same context every single time.
What you teach. What grade. How long the period is. What your kids can actually handle.
How you like things formatted.

**Say it once. Never say it again.** Everything below is that idea at three sizes.

| Size | The problem it solves | Claude | ChatGPT |
|---|---|---|---|
| **Project** | "I keep re-explaining my course" | Projects | Projects |
| **Skill** | "I keep re-explaining how I want *this one job* done" | Skills | Custom GPTs (roughly) |
| **Connector** | "I keep pasting in the state standards" | Connectors (Learning Commons) | Connectors |
| **Agent** | "Don't tell me how — go do it" | Cowork | Agent Mode |

**And the same idea pointed the other way.** Your students aren't re-explaining themselves
either — they've never explained themselves *once.* That's [section 3](#3-for-your-students-the-4-part-prompt),
and it's the half of this page I care most about. You fix yours with a text file. You fix
theirs with a conversation.

---

# 1. Fake Course Context

**This is the block we pasted at minute 19.** Copy it into a new Project's knowledge, build
your standing instructions around it, then throw it away and paste in your real syllabus.

It's a culinary course on purpose — I don't teach culinary. The point isn't the content,
it's the **shape**. Yours will look nothing like this. That's correct.

```
COURSE CONTEXT — Introduction to Culinary Arts

THE COURSE
- Introduction to Culinary Arts, one semester, grades 10-12
- Meets 5 days/week, 52-minute periods. Block day Wednesday (95 min) — that's the only
  day a full multi-stage recipe fits.
- Counts as a CTE credit; articulated for 3 college credits with the community college,
  so assessments have to be defensible at a college level.
- ServSafe Food Handler certification is a required outcome by end of term.

THE ROOM
- 6 kitchen stations, 4 students each. 24 students max, and I am always at 24.
- 2 stations have convection ovens, 4 have standard. Recipes have to work in both or I
  have to split the class.
- 1 shared walk-in. No sous vide, no immersion circulator, no stand mixer per station
  (3 total, shared).
- Budget is roughly $3.50 per student per lab day. This constrains nearly everything.
- No open flame during fire drills week (first week of each semester).

THE STUDENTS
- 24 students, wildly mixed. About 8 have cooked at home regularly and are comfortable
  with a knife. About 10 have never used a chef's knife. A few have real anxiety about
  the stove and I don't push them on day one.
- 4 students on IEPs with reading accommodations — anything text-heavy needs a version
  that isn't a wall of text.
- 3 English learners; food vocabulary is a genuine barrier before technique is.
- Attention and reading stamina vary a lot. Chunk everything. Numbered steps, short lines.

CONSTRAINTS THAT NEVER CHANGE
- Every lab needs a written safety and sanitation step BEFORE any cooking step. Non-negotiable.
- Allergy protocol: nut-free building. Never write a recipe with nuts, ever.
- Cleanup is 12 minutes and it is not optional — any lab plan has to fit cooking AND
  cleanup inside the period.
- Students cannot take food home (district policy).
```

## Standing instructions template

**Fill in the blanks.** This is the part people get wrong — they describe the *course* and
forget the *constraints*. The constraints are where all the value is.

```
STANDING INSTRUCTIONS

When you help me with anything for this course:

FORMAT
- Give me ______________________ (what you actually want: a doc? a table? numbered steps?)
- Keep it to ______________________ (length limit — be specific, "short" means nothing)
- Reading level: ______________________
- Never give me ______________________ (the thing you always delete)

MY KIDS
- Assume they can ______________________
- Assume they CANNOT ______________________
- The thing that always trips them up is ______________________

MY ROOM
- I have ______________________
- I do NOT have ______________________
- A class period is ______ minutes, and realistically ______ minutes of work time.

ALWAYS
- Every ____________ must include ____________
- Never include ____________ (allergy, policy, equipment, safety — whatever your hard no is)

WHEN YOU'RE NOT SURE
- Ask me before assuming. Don't invent a detail about my room to fill a gap.
```

> **The single best line to add:** *"Assume they CANNOT ___."* Most people write what
> their students can do. The limits are what makes output usable.

---

# 2. Starter SKILL.md

**This is the skeleton from minute 53.** A skill is a folder with a markdown file in it.
There is no code here. If you can write a sticky note for a substitute, you can write this.

```markdown
---
name: your-skill-name-here
description: >
  This skill should be used when the user asks to ______________________.
  Also trigger when they say ______________________ or ______________________.
  Output is ______________________.
---

# [Skill Name]

[One sentence: what this produces.]

## Context (always apply)

[Paste the stuff you retype every single time. Your room, your kids, your constraints.
This is the block that saves you. Be specific to the point of feeling excessive —
"32 computers" not "a computer lab."]

## Inputs

[What will I give it? Plain English is fine. "I'll describe an assignment in a sentence."]

## Output Format

[Exactly what you want back, in order. Number the parts. Say how long each should be.]

1.
2.
3.

## Quality Checks

[What makes it wrong? List the mistakes you'd catch. This is the highest-value section
and everyone skips it.]

- [ ]
- [ ]
```

### The one line with a trick in it

`description` is how the model decides **when** to use the skill. Write it like you're
telling a substitute when to reach for it — actual phrases you'd type, not a summary.

**Weak:** `description: Helps with teaching stuff.`
**Strong:** `description: Use when the user asks to build a lab, design a hands-on activity, or says "I want students to practice [tool]." Output is a dual-track student lab, a teacher guide, and reflection questions.`

### Real, working skills — mine, unedited

These are the actual files I use every week, not sanitized examples.

- **[`cyber-lab-builder/SKILL.md`](skills/cyber-lab-builder/SKILL.md)** — the one I demoed.
  Read the **Classroom Context** block at the top; that's the part that transfers to any
  subject. Everything below it is just my content.
- **[`unit-test-writer/SKILL.md`](skills/unit-test-writer/SKILL.md)** — narrower, but it
  shows a skill carrying **reference files and code samples** alongside the markdown. A
  skill can be a folder, not just one file.

> **Requires Code execution enabled**: Settings → Capabilities → Code execution. If Skills
> aren't showing up, this is why, 95% of the time.

---

# 3. For your students: the 4-part prompt

**Credit where it's due:** I got this from a session by **Tim Swick and Mark Davis** at
**CSTA 2026**. It's theirs, not mine. Neither had contact info on their conference profile
and I haven't been able to find them online — **if you know them, please put us in touch.**

## The reversal

I opened the workshop saying prompting barely matters anymore. That's true **for you.** For
your students it's close to the opposite, and the reason is worth being precise about.

Two different things get called prompting:

- **Prompting for better output.** Mostly dead. The models recover from a sloppy ask.
- **Prompting as visible thinking.** Alive, and more important than it's ever been, because it's the only part of the process you can see.

The second one isn't prompt engineering. It's outlining before writing. It's showing your
work in math. We already require this everywhere else — we've just never asked for it here.

> **The problem was never AI. It's underspecified human intent.**

That's the same sentence as the rest of this page. You've been failing to write down what
you want and paying for it every time. Your students are doing the identical thing, once per
assignment instead of once per chat. Same disease, two patients.

## Spot the thinking gap

Try this with your own assignments. Take one, and ask:

**"Write a one-page explanation of the causes of the American Revolution."**

1. **What thinking is required *before* a student can ask this?** — None. They don't have to know a single thing about the American Revolution to type it. That's the problem, and it isn't a cheating problem.
2. **What thinking could AI replace if we're not careful?** — Not the essay. Their *opinion.* And the risk isn't that it hands them a bad one. It hands all thirty of them a perfectly reasonable one, and it's the *same* perfectly reasonable one.

That second point is the one worth an actual class discussion. Have it out loud with your
kids rather than burying it in a syllabus policy.

## The four parts

| Part | The question | Examples |
|---|---|---|
| **Verb** | What thinking move is happening? | Analyze, compare, critique, generate options, simulate. **Name the cognitive move, not the product.** "Write" is not a thinking verb. |
| **Format** | What shape should the thinking take? | Bullet list, table, decision tree, outline, dialogue. Constrain it so a human can evaluate it. Ask for a *step*, not a finished product. |
| **Voice** | From what perspective? | A peer, a skeptic, a novice, a historian, a scientist. Reinforces that it simulates viewpoints, it doesn't hold truth. |
| **Context** | What human constraints matter? | Audience, grade level, purpose, values, limits. **This is where human judgment lives.** It will assume things for you if you don't say them. |

### Weak vs. rewritten

**Weak:** *"Write an essay about AI in schools."*
Invites vague coverage, opinion dumping, and total substitution. No student left in it.

**Rewritten:**
> **Analyze the tradeoffs** *(verb)* of using AI tools in classrooms, **in a two-column
> table** *(format)*, **from the perspective of a school administrator** *(voice)*,
> **focusing on the decisions a middle school has to make about student use and academic
> integrity** *(context)*.

Same assignment. In the second one you can see them think, and you can grade the prompt.

### The two lines worth putting on a poster

> **If students are skipping these steps, they're outsourcing their thinking.**
>
> **If students can't explain these four parts, they shouldn't be using AI yet.**

That second one is a real standard. Teachable, assessable, and a much better policy than
"don't use it."

## How to actually roll it out

1. Do one prompt in front of the class, thinking out loud.
2. Build one together as a group.
3. Let them go solo.
4. Put the four parts on a poster and leave it up.

Gradual release, same as anything else you teach.

## The callback: a Skill is a 4-part prompt you only had to write once

Go look at [`cyber-lab-builder/SKILL.md`](skills/cyber-lab-builder/SKILL.md) again with the
four parts in mind:

- **Format** — the Output Format section. Saved.
- **Voice** — "written for a student who has only ever used a Chromebook." Saved.
- **Context** — the whole Classroom Context block, forty lines. Saved.
- **Verb** — the only thing I type. *"Build me a lab about nmap."*

The teacher move and the student move are the same move. I just industrialized mine because
I got tired of retyping it.

## Where this connects to the free course

Anthropic's [AI Fluency course](https://anthropic.skilljar.com/path/ai-fluency-for-pk-12-educators)
is built on the **4D framework**, developed with Rick Dakan (Ringling College) and Joseph
Feller (University College Cork). The four parts above live inside it:

| 4D | What it covers | Where you saw it |
|---|---|---|
| **Delegation** | What's worth handing over, and what you keep because the struggle *is* the learning | "Humans decide why and whether" |
| **Description** | Communicating what you want | **The four parts. This is the whole box.** |
| **Discernment** | Evaluating what came back | "Outputs sound polished but thin" |
| **Diligence** | Using it responsibly and transparently | "Trust erodes when the process is invisible" — why students showing prompts matters |

Also worth knowing: this lines up with **CSTA's emphasis on Intentional Human Control** over
computing systems, so it's defensible language if you need to justify it to an administrator.

---

# 4. Student privacy — the part that actually matters

## Two gates. They are not the same gate.

| | What it is | Who opens it |
|---|---|---|
| **Gate 1** | The vendor's terms. Anthropic has a FERPA-aligned K-12 DPA and doesn't train on teacher inputs/outputs. | The vendor. **Already open.** |
| **Gate 2** | Whether *you* are authorized to put *that* data into *this* tool. | **Your district. Only your district.** |

**"FERPA-aligned" describes the vendor's obligations. It says nothing about your authorization.**

From Anthropic, July 21, 2026 — whether and how educational data may be used in Claude for
Teachers **is determined by district and state policies.**

Worth knowing: Claude for Teachers is currently an **individual educator** product. There's
no district admin layer yet. When you signed up, nobody at your district approved anything.
You did. That's not a scandal — but you should know it's true.

## The roster key (works forever, no tool required)

Two documents:

1. **The one you send** — every name replaced. Student A, Student B, Student C.
2. **The key** — maps A → real name. Lives on your machine. **Never uploaded, never pasted, never leaves.**

What leaves your machine has no identifiers in it. That's the whole technique.

### It's not just names

In a school of 900, all of these identify a specific kid:

- [ ] Names — students, parents, siblings, teachers
- [ ] Student ID numbers, lunch numbers, emails, usernames
- [ ] **"The student who moved here from Guam in October"** — narrative details are identifiers
- [ ] Written-out IEP or 504 accommodations
- [ ] Medical details — the service dog, the allergy, the seizure plan
- [ ] Discipline incidents with dates
- [ ] Anything about a kid whose situation is locally famous
- [ ] Photos, scanned handwriting, screenshots with a name bar visible
- [ ] Filenames — `smith_jordan_essay_final.docx` is an identifier

**Strip narrative details, not just proper nouns.** That's where people get caught.

## The email to send Monday

Fill in one name. Send it. Whatever comes back, you're covered — and you're the person who asked.

```
Subject: Approval question — AI tools and student data

Hi [Director of Technology / CIO / whoever owns data privacy],

I've started using [Claude for Teachers / ChatGPT for Teachers] for lesson planning and
materials development. The vendor has a FERPA-aligned K-12 data protection agreement, but
I understand that whether and how student data may be used is determined by district
policy, not the vendor's terms.

Two questions:
1. Is this tool approved for staff use in our district?
2. If so, is there a policy on what student data — if any — may be entered? I'm currently
   de-identifying everything as a default.

Happy to share what I'm doing if that's useful.

Thanks,
[You]
```

## Risk tiers — know which one you're in

| What you're doing | Student data? | Risk |
|---|---|---|
| Planning, drafting, building materials | None | Low. Go. |
| De-identified student work for feedback patterns | Stripped | Moderate. Roster key. Ask anyway. |
| Real names, real records, real grades | **Yes — these are education records** | **Stop. Gate 2 first.** |
| Pointing an agent at a folder of student files | **Yes, and more of it** | **Stop. Get it in writing.** |

The moment a tool can read a folder, "what's in that folder" becomes a records question.

---

# 5. Claude ↔ ChatGPT

I taught this in Claude because it's what I use daily and the Teachers offer is the best
deal available right now. The description promised both platforms, so:

| | Claude | ChatGPT |
|---|---|---|
| **Free for K-12 teachers** | Claude for Teachers — free Pro-level. **Verify by June 30, 2027** for a full free year. | ChatGPT for Teachers — free for verified US K-12 through **June 2028**. |
| **Per-course context** | Projects | Projects |
| **Reusable job instructions** | Skills (needs Code execution on) | Custom GPTs |
| **External data** | Connectors — incl. Learning Commons: academic standards for all 50 states, OpenSciEd, Illustrative Mathematics | Connectors |
| **Agent that does the work** | Cowork — paid seats only | Agent Mode |
| **Training on your data** | No, for teacher inputs/outputs under the K-12 DPA | Check current terms for your plan |

**The idea transfers.** Stop re-explaining yourself works identically in both. Pick one,
learn it deeply — that beats knowing both shallowly.

---

# 6. Next steps, in order

1. **Tonight (5 min)** — swap your real syllabus into the Project you built.
2. **Monday (2 min)** — send the district email above.
3. **Monday, with your kids (0 min prep)** — put **Verb / Format / Voice / Context** on the board. One assignment. You don't need a policy or a district rollout to start.
4. **When you have a couple of hours** — [**AI Fluency for PK-12 Educators**](https://anthropic.skilljar.com/path/ai-fluency-for-pk-12-educators). Free, from Anthropic, two tracks. That's the 4D framework taught properly, and it picks up where the four parts leave off. I deliberately didn't teach it — you can do it alone, and I'd rather have used the room for the part you can't.
5. **When something annoys you twice** — that's a Skill. Write it down.

---

## Contact

Eric Ogden — [Substack](https://ericogden.substack.com) · [github.com/parties](https://github.com/parties)

Available for district PD and workshop facilitation.

*Fully licensed for reuse — take any of this into your own classroom or PD.
Attribution appreciated, not required.*
