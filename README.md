# Stop Re-Explaining Yourself

**CTE Workshop — August 2026**
Eric Ogden · high school CS teacher (AP CSP, AP CS A, Cybersecurity, Intro to CS, Video Game Design) · 12 years as a software engineer before teaching.

Everything from the session is here. Nothing gated, no signup.

---

## Do this first — the whole activity, in one place

1. Find an assignment your students **AI'd their way through** last year; save it as a file (txt, docx, pdf, md, html, doesn't matter)
2. Open your AI of choice — new **Project** (Claude) / **Gem** (Gemini) / **Custom GPT** (ChatGPT)
3. Upload **[`framework.md`](framework.md)** to your project/gem/custom GPT
4. Paste the **[conversion prompt](conversion-prompt.md)** into the chat, attach your assignment
5. Read what comes back — then **push back on it**, *iterate*

Didn't bring an assignment? Use **[`sample-assignment.md`](sample-assignment.md)** — it has a
filled-in context block, so you can be running in about thirty seconds.

> **Upload your assignment, not your students' work.** If you want to show it what a kid
> actually turned in, strip the name first. See [Student privacy](#student-privacy).

---

## The idea

Two halves, same sentence.

**You** have been doing the same job for years and re-typing the same context every single
time. What you teach, what grade, how long the period is, what your kids can actually handle.
Say it once, never say it again — that's what a Project is for.

**Your students** have never written their context down *once.* They type six words and
accept whatever comes back.

> **The problem was never AI. It's underspecified human intent.**

Same disease, two patients. You fix yours with a text file. You fix theirs with a conversation.

---

## The four parts

*Framework by **Tim Swick and Mark Davis**, CSTA 2026. Neither had contact info on their
conference profile and I haven't been able to find them online — **if you know them, please
put us in touch.** I have a list of questions.*

Full version, with examples and the rollout plan: **[`framework.md`](framework.md)**

| Part | The question | Examples |
|---|---|---|
| **Verb** | What thinking move is happening? | Analyze, compare, critique, prioritize, refute. **"Write" is not a thinking verb.** |
| **Format** | What shape makes the thinking visible? | Table, decision tree, ranked list, dialogue. Constrain it so gaps show structurally. |
| **Voice** | From what perspective? | A skeptic, a novice, a regulator, a customer. Teaches that it *simulates* viewpoints. |
| **Context** | What human constraints matter? | Audience, grade, purpose, limits. **This is where human judgment lives.** |

**Weak:** *"Write an essay about AI in schools."*

**Rewritten:** *"**Analyze the tradeoffs** of using AI tools in classrooms, **in a two-column
table**, **from the perspective of a school administrator**, **focusing on the decisions a
middle school has to make** about student use and academic integrity."*

Same topic. Now you can see them think — and you can grade the prompt.

> **If students are skipping these steps, they're outsourcing their thinking.**
>
> **If students can't explain these four parts, they shouldn't be using AI yet.**

The second one is a real standard. Teachable, assessable, and better than "don't use it,"
which has never worked anywhere.

---

## Student privacy

### Two gates. They are not the same gate.

| | What it is | Who opens it |
|---|---|---|
| **Gate 1** | The vendor's terms. Anthropic has a FERPA-aligned K-12 DPA and doesn't train on teacher inputs/outputs. | The vendor. **Already open.** |
| **Gate 2** | Whether *you* are authorized to put *that* data into *this* tool. | **Your district. Only your district.** |

**"FERPA-aligned" describes the vendor's obligations. It says nothing about your authorization.**

Anthropic's July 21, 2026 clarification: whether and how educational data may be used in
Claude for Teachers is determined by **district and state policies.**

Claude for Teachers is currently an **individual educator** product — there's no district
admin layer. When you sign up, nobody at your district approves anything. You do.

### The roster key

Two documents. **The one you send** has every name replaced with Student A, B, C. **The key**
maps them back and lives on your machine — never uploaded, never pasted, never leaves.

What leaves has no identifiers in it. That's the whole technique.

### It's not just names

In a school of 900, all of these identify a specific kid:

- [ ] Student IDs, lunch numbers, usernames, emails
- [ ] **"The student who moved here from Guam in October"**
- [ ] IEP or 504 accommodations written out
- [ ] Medical details — the service dog, the allergy, the seizure plan
- [ ] Discipline incidents with dates
- [ ] Photos, scanned handwriting, screenshots with a name bar
- [ ] Filenames — `smith_jordan_essay_final.docx`

**Strip narrative details, not just proper nouns.** That's where people get caught.

### The email to send Monday

```
Subject: Approval question — AI tools and student data

Hi [Director of Technology / CIO / whoever owns data privacy],

I've started using [Claude / ChatGPT / Gemini] for lesson planning and materials
development. The vendor has a FERPA-aligned K-12 data protection agreement, but I
understand that whether and how student data may be used is determined by district
policy, not the vendor's terms.

Two questions:
1. Is this tool approved for staff use in our district?
2. If so, is there a policy on what student data — if any — may be entered? I'm
   currently de-identifying everything as a default.

Happy to share what I'm doing if that's useful.

Thanks,
[You]
```

### Risk tiers

| What you're doing | Student data? | Risk |
|---|---|---|
| Planning, drafting, converting assignments | None | Low. Go. |
| De-identified student work for feedback patterns | Stripped | Moderate. Roster key. Ask anyway. |
| Real names, real records, real grades | **Yes — education records** | **Stop. Gate 2 first.** |
| Pointing an agent at a folder of student files | **Yes, and more of it** | **Stop. Get it in writing.** |

### PII Anonymizer — in development

Watch this repo for releases. The workflow it's built for:

1. Export your Google Form responses as a spreadsheet
2. Run it through the anonymizer → names become Student A, B, C
3. Upload **that**, ask for patterns and feedback
4. Paste the response back into the tool → **names come back**

The roster key, automated. Real feedback on real student work without the real names ever
leaving your machine. **Until it ships, do it by hand. By hand works.**

---

## All three platforms

| | Claude | ChatGPT | Gemini |
|---|---|---|---|
| **Free for K-12 teachers** | Claude for Teachers — verify by **Jun 30, 2027** for a free year | ChatGPT for Teachers — free through **Jun 2028** | Via Google Workspace for Education |
| **Per-context container** | Projects | Projects | Gems |
| **Reusable job instructions** | Skills | Custom GPTs | Gems |
| **Agent that does the work** | Cowork (paid) | Agent Mode | — |

**Claude for Teachers verification requires a school ID and takes days.** Start it tonight —
it will not resolve in a workshop.

Everything in this repo works on **free accounts on any of the three.** Pick one and learn it
deeply. That beats knowing all three badly.

---

## Skills — where this goes next, when you're ready

A Skill is a folder with a markdown file in it. **No code.** It's how you stop re-explaining
yourself for one specific job, permanently.

Two real ones of mine, unedited:

- **[`skills/cyber-lab-builder/SKILL.md`](skills/cyber-lab-builder/SKILL.md)** — the one I demoed. Read the **Classroom Context** block at the top: 32 Dell Precisions, VirtualBox, 15 beginners and 5 advanced, dual credit. Forty lines, written once, never retyped. That block is the part that transfers to any subject.
- **[`skills/unit-test-writer/SKILL.md`](skills/unit-test-writer/SKILL.md)** — narrower, but it shows a skill carrying reference files and code samples. A skill can be a folder, not one file.

**A Skill is a four-part prompt you only had to write once.** Format, Voice, and Context are
saved in the file. The Verb is the only thing you type.

> ### Why I didn't teach skill-building in the session
>
> Installing a skill means running someone else's instructions. That's a supply chain, and it
> deserves more than eight minutes — including mine, especially mine. I teach cybersecurity
> and I'm not going to walk a room through installing something from a stranger's GitHub.
>
> That's also why the thing I handed you today is a prompt and a markdown file. Copy, paste,
> nothing to install, nothing to trust.
>
> When you're ready, that's the rabbit hole. Go in deliberately.

---

## Next steps, in order

1. **Tonight (5 min)** — start Claude for Teachers verification. It takes days.
2. **Monday (2 min)** — send the district email above.
3. **Monday, with your kids (0 prep)** — put **Verb · Format · Voice · Context** on the board. One assignment. You don't need a policy or a district rollout to start.
4. **When you have a couple of hours** — [**AI Fluency for PK-12 Educators**](https://anthropic.skilljar.com/path/ai-fluency-for-pk-12-educators). Free, from Anthropic. The 4D framework taught properly — it picks up exactly where the four parts leave off.
5. **When something annoys you twice** — that's a Skill. Write it down.

---

## Contact

Eric Ogden — [github.com/parties](https://github.com/parties)

Available for district PD and workshop facilitation.

*Free to reuse in your own classroom or PD. Attribution appreciated, not required.*
